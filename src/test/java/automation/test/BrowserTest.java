package automation.test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	//Main method to run the First selenium Script
	public static void main(String[] args) {
		//Webdriver manager helps to download drivers using maven dependency 
		WebDriverManager.chromedriver().setup();
		
		/* Commented below code as it is not required if I am using WebDriverManager
		String projectPath = System.getProperty("user.dir");
		//Setting up property for location of chrome driver 
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver");
		*/
		
		//Creating WebDriver object to perform automation on chrome browser
		WebDriver driver = new ChromeDriver();
		
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
		we.sendKeys("Accenture");
		we.sendKeys(Keys.TAB);
		
		
		//Reusing same object to click on Google Search using XPATH as an identifier 
		we = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));
		we.click();
		
		winTitle = driver.getTitle();
		if (winTitle.equals("Accenture - Google Search")) {
			System.out.println("Passed : Expected Title " + winTitle + " is present.");
		}else {
			System.out.println("Failed : Expected Title " + winTitle + " is not matching with actual "+ winTitle);
		}
		
		//Closing the driver at the end
		driver.close();
		driver.quit();

	}

}
