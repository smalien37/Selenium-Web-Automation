package testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestObjects.testObjects1;
import TestObjects.testObjects2;
import TestObjects.testObjects3;
import utilities.DataInputOutput;
import utilities.DriverSetup;
import utilities.extentReport;

public class master_testcase extends DriverSetup{
	
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
			testObjects2.homePage(driver);
		}
		
		
		@Test(priority=3)
		public void enterprisePAGE_Test() throws Exception{
			j=0;
			test=report.createTest("Enterprise Page Test");
			try {
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			testObjects2.forEnterprise(driver).click();	
			test.log(Status.PASS, "Enterprise_clicked");
			}catch(Exception e) {
				try {
					DriverSetup.reportfail(e.getMessage());
					j=1;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			Thread.sleep(5000);
			testObjects2.getTitle(driver.getTitle());
			
	}
	
	
		@Test(priority=4)
		public void campusPAGE_Test() throws Exception{
			test=report.createTest("Campus Page Test");
	//		Thread.sleep(4000);
	//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//		Actions a=new Actions(driver);
	//		a.moveToElement(testObjects2.product(driver)).build().perform();
			if(j==0) {
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			testObjects2.forCampus(driver);
			Thread.sleep(5000);
			testObjects2.getTitle2(driver.getTitle());}
			else 
			throw new SkipException("SKIP_TEST");	
		}
		
		@Test(priority=5)
		public void formFillTest() throws Exception{
			test=report.createTest("Ready_to_Transform form_fillup Test");
			d=DataInputOutput.readexcel();
			Thread.sleep(8000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", testObjects2.firstName(driver));
			testObjects2.firstName(driver).sendKeys(d[1][0]);
			test.log(Status.PASS, "First_name_inserted");
			testObjects2.lastName(driver).sendKeys(d[1][1]);
			test.log(Status.PASS, "Last_name_inserted");
			testObjects2.email(driver).sendKeys(d[1][2]);
			test.log(Status.PASS, "E-mail_inserted");
			testObjects2.jobTitle(driver).sendKeys(d[1][3]);
			test.log(Status.PASS, "Job_Title_inserted");
			testObjects2.phNum(driver).sendKeys(d[1][4]);
			test.log(Status.PASS, "Phone_name_inserted");
			testObjects2.instituteName(driver).sendKeys(d[1][5]);
			test.log(Status.PASS, "Institute_name_inserted");
			testObjects2.instituteType(driver).click();
			testObjects2.instituteType(driver).sendKeys(Keys.ARROW_DOWN);
			testObjects2.numOfstuds(driver).sendKeys(Keys.TAB);
			testObjects2.numOfstuds(driver).sendKeys(Keys.ARROW_DOWN);
			testObjects2.courseraUsers(driver).sendKeys(Keys.TAB);
			testObjects2.courseraUsers(driver).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			testObjects2.country(driver).click();
			testObjects2.country(driver).sendKeys(Keys.ARROW_DOWN);
			testObjects2.country(driver).sendKeys(Keys.TAB);
			Thread.sleep(1000);
			testObjects2.country(driver).sendKeys(Keys.TAB);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			testObjects2.state(driver).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(4000);
			testObjects2.submit(driver).click();
			test.log(Status.PASS, "Apply_clicked");
			Thread.sleep(3000);
			error_msg=testObjects2.errorMsg(driver).getText();
			DataInputOutput.writetoexceltestcase2(error_msg);
			testObjects2.homePage(driver);
			Thread.sleep(5000);
		}
		
		@Test(priority=6)
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
		
		@Test(priority=7)
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
