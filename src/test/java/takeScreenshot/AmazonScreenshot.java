package takeScreenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AmazonScreenshot {
	WebDriver driver;
	@BeforeTest
	public void launchApp() throws Exception
	{
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	@AfterTest
	public void closeApp() throws Exception
	{
		Thread.sleep(4000);
		driver.close();
	}
	@Test
	public void verifyWishlist() throws Exception
	{
		//Create object of Action class
		Actions act = new Actions(driver);
		
		WebElement SignIn = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		//WebElement SignIn = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		WebElement CreateWishList = driver.findElement(By.xpath("//span[contains(text(),'Create a Wish List')]"));
		
		//Hover on Sign In and then click on Create Wish List
		act.moveToElement(SignIn).click(CreateWishList).perform();
		
		//Take Screenshot, target a folder and then copy screenshot file to target folder
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File (".\\screenshots\\AmazonScreenshot.png");
		
		FileUtils.copyFile(screenshotFile, target);
		
		//TakesScreenshot is an interface
	}

}
