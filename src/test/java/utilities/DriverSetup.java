package utilities;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class DriverSetup 
{
	public static WebDriver driver;

	public static String exePath;
	public static String url = "https://coursera.org/";
	public static String browsertype;
	public static ExtentTest test;
	
	public static WebDriver driverInstantiate(String browser){
	
		browsertype= browser;
	
		if(browsertype.equalsIgnoreCase("chrome")) {
			exePath = "F:\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
		}
	
		else if(browser.equalsIgnoreCase("firefox")) {
			exePath = "D:\\Sele\\driver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("ie")) {
			exePath = "D:\\Sele\\driver\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", exePath);
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public static void driverClose(){
	driver.close();
	}
	
	public static void reportfail(String s) throws Exception {
		test.log(Status.FAIL,s);
		TakeScreenshot.screenShotTC(driver);
		Assert.fail(s);
	}
	
	public static void reportpass(String s) throws Exception {
		test.log(Status.PASS,s);
	}

}
