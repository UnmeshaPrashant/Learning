package ControlExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {
	WebDriver driver;

	@BeforeTest
	public void launchApp() throws Exception {

		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();

	}
	 @Test
	    public void DragAndDropTest() throws InterruptedException {
		 WebElement myframe = driver.findElement(By.xpath("//iframe[contains(@data-src,'demoSite/practice/droppable/photo-manager.html')]"));
		 driver.switchTo().frame(myframe);

	        // Create an Object of Actions class

	        Actions act = new Actions(driver);

	        WebElement img = driver.findElement(By.xpath("//img[@src='images/high_tatras_min.jpg']"));
	        WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));
	        
	        act.dragAndDrop(img, target).perform();
	        
	        
	    }


}
