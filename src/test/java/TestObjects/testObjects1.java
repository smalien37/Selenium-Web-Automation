package TestObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.DriverSetup;

public class testObjects1 {
	
	public static WebElement element = null;
	public static WebDriver driver;
	
	public static WebElement exploreBtn(WebDriver driver) { //Action_mouse_movement
	//	element =driver.findElement(By.xpath("/html/body/div[2]/div/div/span/div[2]/header/div[3]/div/div[1]/div/div/div[2]/div/div[1]/div/button"));
		element =driver.findElement(By.xpath("//button[@id='explore_button_button']"));
		return element;
	}
	
	public static WebElement computerScience(WebDriver driver) {  //click
		element =driver.findElement(By.xpath("//li[3]//div[1]//button[1]//span[2]"));
		return element;
	}
	
	public static WebElement webDevelopment(WebDriver driver){  //click
		element =driver.findElement(By.xpath("//li[3]//div[1]//button[1]"));
		return element;
	}
	
	public static WebElement skills(WebDriver driver){//click
		element =driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/section/div[3]/section/div[1]/section/div/button[1]"));
		return element;
	}
	
	public static WebElement dev(WebDriver driver){//search
		element =driver.findElement(By.xpath("//input[@placeholder='Search for skills']"));
		return element;
	}
	
	public static WebElement check(WebDriver driver){//search
		element =driver.findElement(By.xpath("//label[2]//input[1]"));
		return element;
	}
	
	public static WebElement level(WebDriver driver){//click
		element =driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/section/div[3]/section/div[1]/section/div/button[3]"));
		return element;
	}
	
	public static WebElement beginner(WebDriver driver){//click
		element =driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div[1]/div/div/div/div/div/label[2]/input"));
		return element;
	}
	
	public static WebElement language(WebDriver driver){//click
		element =driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/section/div[3]/section/div[1]/section/div/button[4]"));
		return element;
	}
	
	public static WebElement english(WebDriver driver){//click
		element =driver.findElement(By.xpath("//label[14]//input[1]"));
		return element;
	}
	
	public static WebElement apply(WebDriver driver){//click
		 element = driver.findElement(By.xpath("//button[@class='_1hx9z6hg']"));
		return  element;
	}
	
	public static WebElement name(WebDriver driver,int i) {
		if(i==0) {
			element = driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div/div[1]/h4"));
			return  element;}
		else
			element = driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/h4"));
			return  element;	
	}
	
	public static WebElement rating(WebDriver driver,int i) {
		if(i==0) {
			element = driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/section/span[1]/div/span"));
			return  element;}
		else
			element = driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/section/span[1]/div/span[1]"));
			return  element;	
	}
	
	public static WebElement hours(WebDriver driver,int i) {
		if(i==0) {
			element = driver.findElement(By.xpath("//span[contains(text(),'48 hours')]"));
			return  element;}
		else
			element = driver.findElement(By.xpath("//span[contains(text(),'18 hours')]"));
			return  element;	
	}
	
	public static void getTitle(String z){
		try {
			Assert.assertEquals(z,"Computer Science Online Courses | Coursera");
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
	
	//RESULTS-name
//	/html/body/div[2]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div/div[1]/h4
//	/html/body/div[2]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/h4

	
	//RESULTS-rating
//	/html/body/div[2]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/section/span[1]/div/span
//	/html/body/div[2]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/section/span[1]/div/span[1]
	
	//RESULTS-hours
//	/html/body/div[2]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/section/span[3]/span
//	/html/body/div[2]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/section/span[3]/span

}
