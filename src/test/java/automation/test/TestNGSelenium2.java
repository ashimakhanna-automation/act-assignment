package automation.test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

//Class has created to run TestNG in parallel with testng.xml
public class TestNGSelenium2 {
	WebDriver driver = null;
  
  @BeforeTest
  public void setUpTest() {
	  System.out.println("Starting Test Execution");
	  //Webdriver manager helps to download drivers using maven dependency 
	  WebDriverManager.chromedriver().setup();
	
	  //Creating WebDriver object to perform automation on chrome browser
	  driver = new ChromeDriver();
  }
  
  @Test
  public void googleSearch1() {
		//Navigating to the url
		driver.get("http://www.google.com");
		//Verifying Window Title
		String winTitle = driver.getTitle();
		if (winTitle.equals("Google")) {
			System.out.println("Passed : Expected Title " + winTitle + " is present.");
		}else {
			System.out.println("Failed : Expected Title " + winTitle + " is not matching with actual "+ winTitle);
		}
		//Creating a web element object based on unique property to perform action on it
		WebElement we = driver.findElement(By.name("q"));
		we.sendKeys("Ashima Khanna Abrol");
		we.sendKeys(Keys.TAB);
		
		
		//Reusing same object to click on Google Search using XPATH as an identifier 
		we = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));
		we.click();
		
		winTitle = driver.getTitle();
		if (winTitle.equals("Ashima Khanna Abrol - Google Search")) {
			System.out.println("Passed : Expected Title " + winTitle + " is present.");
		}else {
			System.out.println("Failed : Expected Title " + winTitle + " is not matching with actual "+ winTitle);
		}

  }
  @AfterTest
  public void teardownTest() {
	//Closing the driver at the end
	driver.close();
	driver.quit();
	System.out.println("Test Execution Completed!");

  }
}
