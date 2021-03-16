package TestObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.DriverSetup;

public class testObjects3 {
	public static WebElement element = null;
	public static WebDriver driver;
	
	public static WebElement exploreBtn(WebDriver driver) { //Action_mouse_movement
	//	element =driver.findElement(By.xpath("/html/body/div[2]/div/div/span/div[2]/header/div[3]/div/div[1]/div/div/div[2]/div/div[1]/div/button"));
		element =driver.findElement(By.xpath("//button[@id='explore_button_button']"));
		return element;
	}
	
	public static WebElement language(WebDriver driver){//click
		element =driver.findElement(By.xpath("//li[11]//div[1]//button[1]//span[2]"));
		return element;
	}
	
	public static WebElement languagetab(WebDriver driver){//click
		element =driver.findElement(By.xpath("//span[@class='_1lutnh9y'][contains(text(),'Language')]"));
		return element;
	}
	
	public static WebElement level(WebDriver driver){//click
		element =driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/section/div[3]/section/div[1]/section/div/button[3]"));
		return element;
	}
	

	public static WebElement list1(WebDriver driver,int i){
		element =driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div[1]/div/div/div/div/div/label["+i+"]/span[2]"));
		return element;
	}

	public static WebElement list2(WebDriver driver,int i){
		if(i==1) {
			element =driver.findElement(By.xpath("//div[@class='ReactModalPortal']//label[1]"));
		return element;}
		else {
		element =driver.findElement(By.xpath("//label["+i+"]"));
		return element;}
	}
	
	public static void getTitle(String z){
		try {
			Assert.assertEquals(z,"Language Learning Online Courses | Coursera");
			DriverSetup.reportpass("Page_Titles_matched");
		}catch(Exception e) {
			try {
				DriverSetup.reportfail(e.getMessage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
					
}
