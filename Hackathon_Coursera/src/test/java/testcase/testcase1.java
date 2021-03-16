package testcase;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestObjects.testObjects1;
import TestObjects.testObjects2;
import utilities.DataInputOutput;
import utilities.DriverSetup;
import utilities.TakeScreenshot;
import utilities.extentReport;

public class testcase1 extends DriverSetup{
	
	public String[] pt=new String[2];
	public String[] q=new String[2];
	public String[] h=new String[2];
	public List<WebElement> listofvalues,list1;
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	private String s="web development";
	public String error_msg;
	public static String[][] d=new String[2][6];
	public String[] k=new String[37];
	public String[] r=new String[4];
	public int j=0;
	
		@BeforeTest
			public void driverconfig(){
				driver=DriverSetup.driverInstantiate("chrome");
				report=extentReport.getReportInstance();
		}
		
				
		@Test(priority=1)
		public void explore_Web_Development_Page_Test() {
			test=report.createTest("Explore Web_Development Test");
			try {
			Thread.sleep(4000);	
			test.log(Status.INFO, "Explore Button OperatioN");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions a=new Actions(driver);
			a.moveToElement(testObjects1.exploreBtn(driver)).build().perform();
			test.log(Status.PASS, "Clicked On Explore Button successfully");
			Thread.sleep(4000);
			}catch(Exception e) {
				try {
					DriverSetup.reportfail(e.getMessage());
					j=1;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions s=new Actions(driver);
			s.moveToElement(testObjects1.computerScience(driver)).build().perform();
			Thread.sleep(4000);
			testObjects1.webDevelopment(driver).click();
			if(j==0)
			test.log(Status.PASS, "Clicked on Computer Science WebDevelopment");
			else
			test.log(Status.SKIP, "Clicked on Computer Science WebDevelopment");
			Thread.sleep(12000);
			}catch(Exception e) {
				try {
					DriverSetup.reportfail(e.getMessage());
					j=1;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(j!=1)
			testObjects1.getTitle(driver.getTitle());
		}
	
	
	@Test(priority=2)
	public void filterAccessTest() {
		test=report.createTest("Applying Web Development Filters");
		try {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		testObjects1.level(driver).click();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		testObjects1.beginner(driver).click();
		Thread.sleep(3000);
		test.log(Status.PASS, "beginner_checked");}
		catch(Exception e) {
			try {
				DriverSetup.reportfail(e.getMessage());
				j=1;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		try {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		testObjects1.language(driver).click();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		testObjects1.english(driver).click();
		Thread.sleep(3000);
		test.log(Status.PASS, "English_checked");}
		catch(Exception e) {
			try {
				DriverSetup.reportfail(e.getMessage());
				j=1;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		try {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		testObjects1.skills(driver).click();
		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		testObjects1.dev(driver).sendKeys(s);
		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		testObjects1.check(driver).click();
		test.log(Status.PASS, "Course_checked");}
		catch(Exception e) {
			try {
				DriverSetup.reportfail(e.getMessage());
				j=1;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		try {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		testObjects1.apply(driver).click();	
		test.log(Status.PASS, "Clicked_on_apply");
		Thread.sleep(7000);
		for(int j=0;j<2;j++) {
			pt[j]=testObjects1.name(driver, j).getText();
			q[j]=testObjects1.rating(driver, j).getText();
			h[j]=testObjects1.hours(driver, j).getText();
			DataInputOutput.writetoexceltestCase1(pt,q,h);
			Thread.sleep(2000);
		}}catch(Exception e) {
			try {
				DriverSetup.reportfail(e.getMessage());
				j=1;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
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
