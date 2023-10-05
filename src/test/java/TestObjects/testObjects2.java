package TestObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.DriverSetup;

public class testObjects2 {
	
	public static WebElement element = null;
	public static WebDriver driver;
	
		public static void homePage(WebDriver driver) {
		driver.get("https://coursera.org/");
		}
	
		public static WebElement forEnterprise(WebDriver driver){
		element =driver.findElement(By.xpath("//a[@id='enterprise-link']"));	
	//	element =driver.findElement(By.xpath("/html/body/div[2]/div/div/span/div[2]/header/div[3]/div/div[1]/div/div/div[4]/span[1]/span/a"));
		return element;
		}
		

		public static WebElement product(WebDriver driver){//mouse_movemet
//		element =driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/ul/li[2]/a"));
		element =driver.findElement(By.xpath("//*[@id='menu-item-2442]"));
		return element;
		}

		public static void forCampus(WebDriver driver){
	//	element =driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/ul/li[2]/ul/li[1]/a"));
	//	return element;
		driver.get("https://www.coursera.org/campus/?utm_campaign=website&utm_content=product-dropdown-coursera-for-campus&utm_medium=coursera&utm_source=enterprise");
		}

		//A_new_Tab_is_opened_&_u_gotta_scroll_to_bottom

		public static WebElement firstName(WebDriver driver) {
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[1]/div[1]/div[2]/input"));
		return element;
		}

		public static WebElement lastName(WebDriver driver) {
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[1]/div[2]/div[2]/input"));
		return element;
		}

		public static WebElement email(WebDriver driver) {
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[2]/div[1]/div[2]/input"));
		return element;
		}

		public static WebElement jobTitle(WebDriver driver) {
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[2]/div[2]/div[2]/input"));
		return element;
		}

		public static WebElement phNum(WebDriver driver) {
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[3]/div[1]/div[2]/input"));
		return element;
		}

		public static WebElement instituteName(WebDriver driver) {
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[3]/div[2]/div[2]/input"));
		return element;
		}

		public static WebElement instituteType(WebDriver driver) {//select_idex=2
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[4]/div[1]/div[2]/select"));
		return element;
		}

		public static WebElement numOfstuds(WebDriver driver) {//select_idex=3
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[4]/div[2]/div[2]/select"));
		return element;
		}

		public static WebElement courseraUsers(WebDriver driver) {//select_idex=3
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[4]/div[3]/div[2]/select"));
		return element;
		}

		public static WebElement country(WebDriver driver) {//select_idex=3
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[5]/div[1]/div[2]/select"));
		return element;
		}
		
		public static WebElement state(WebDriver driver) {//select_idex=3
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[5]/div[2]/div[2]/select"));
		return element;
		}
		

		public static WebElement submit(WebDriver driver) {
		element =driver.findElement(By.xpath("/html/body/section/div/div/div[7]/div/div/div[2]/form/div[16]/span/button"));
		return element;
		}
		
		public static WebElement errorMsg(WebDriver driver) {
		element =driver.findElement(By.xpath("//*[@id=\"mktoForm_1512\"]/div[2]/div[1]/div[2]/div[2]/div[2]"));
		return element;
		}//*[@id="mktoForm_1512"]/div[2]/div[1]/div[2]/div[2]/div[2]
		
		public static void getTitle(String z) {
			try {
				Assert.assertEquals(z,"Coursera for Business | Employee Training and Development Programs");
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
		
		public static void getTitle2(String z) {
			try {
				Assert.assertEquals(z,"Coursera for Campus | Online Learning Platform for Universities");
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
