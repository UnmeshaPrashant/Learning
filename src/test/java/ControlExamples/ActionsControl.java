package ControlExamples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;


public class ActionsControl {
	WebDriver driver;

	@BeforeTest
	public void launchApp() throws Exception {

		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();

	}

	@Test
	public void verifyRightClickTest() {

		// Create an Object of Actions class

		Actions act = new Actions(driver);
		
		WebElement rightButton = driver.findElement(By.xpath("//span[contains(text(),'right')]"));
		WebElement delete = driver.findElement(By.xpath("//span[contains(text(),'Del')]"));

		act.contextClick(rightButton).perform();
		delete.click();

		// handle Alert
		Alert a = driver.switchTo().alert();

		System.out.println(a.getText());
		Assert.assertTrue(a.getText().contains("delete"));

		a.dismiss();

	}

	//@Test
	public void verifyDoubleClickTest() {

		// Create an Object of Actions class

		Actions act = new Actions(driver);

		WebElement doubleButton = driver.findElement(By.xpath("//span[contains(text(),'right')]"));

		act.doubleClick(doubleButton).perform();

		// handle Alert
		Alert a = driver.switchTo().alert();

		System.out.println(a.getText());
		Assert.assertTrue(a.getText().contains("double"));

		a.dismiss();
	}

}
