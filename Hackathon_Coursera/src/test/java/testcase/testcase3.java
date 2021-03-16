package testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestObjects.testObjects3;
import utilities.DataInputOutput;
import utilities.DriverSetup;
import utilities.TakeScreenshot;

public class testcase3 extends DriverSetup{
	
	
	public String[] pt=new String[2];
	public String[] q=new String[2];
	public String[] h=new String[2];
	public List<WebElement> listofvalues,list1;
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	public String error_msg;
	public static String[][] d=new String[2][6];
	public String[] k=new String[37];
	public String[] r=new String[4];
	public int j=0;
	
		@Test(priority=1)
//		@Parameters({"browser"})
			public void driverconfig(){
				driver=DriverSetup.driverInstantiate("chrome");
				System.out.println("Driver_Created");
		}
		
		@Test(priority=1)
		public void languageLearningPAGE_Test() {
			test=report.createTest("Language Learning Page Test");
			try {
			Thread.sleep(4000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions a=new Actions(driver);
			a.moveToElement(testObjects3.exploreBtn(driver)).build().perform();
			Thread.sleep(3000);
			testObjects3.language(driver).click();
			test.log(Status.PASS, "Language_learning_clicked");
			Thread.sleep(2000);}
			catch(Exception e) {
				try {
					DriverSetup.reportfail(e.getMessage());
					j=1;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			testObjects3.getTitle(driver.getTitle());
		}
		
		@Test(priority=2)
		public void totalCountTset() throws Exception{
			test=report.createTest("Total Count Test");
			Thread.sleep(4000);
			testObjects3.languagetab(driver).click();
			test.log(Status.PASS, "Clicked_on_Languagetab");
			Thread.sleep(2000);
			for(int i=1;i<=36;i++){
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				k[i-1]=testObjects3.list2(driver,i).getText();}
			Thread.sleep(2000);
			testObjects3.level(driver).click();
			test.log(Status.PASS, "Clicked_on_Leveltab");
			Thread.sleep(3000);
			for(int i=1;i<=4;i++){
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				r[i-1]=testObjects3.list2(driver, i).getText();}
			DataInputOutput.writetoexceltestcase3(k,r);
			TakeScreenshot.screenShotTC(driver);
		}		
		
		@AfterMethod
		public void setTestResult(ITestResult r) {
			if(r.getStatus()==ITestResult.FAILURE) {
				test.fail(r.getName());
				test.fail(r.getThrowable());
			}else if(r.getStatus()==ITestResult.SUCCESS) {
				test.pass(r.getName());
			}else if(r.getStatus()==ITestResult.SKIP) {
				test.skip("Test_Case_: "+r.getName()+" has been skippped");
			}
		}	
		

		@AfterTest
			public void driverexit(){
				DriverSetup.driverClose();
				report.flush();
				System.out.println("Driver_Closed");
			}	
		

}
