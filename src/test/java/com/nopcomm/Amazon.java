package com.nopcomm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	@Test
	public void amazonx() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		//xpath with indexing
		
		List<WebElement> seemore = driver.findElements(By.xpath("//a[contains(text(), 'See more')]"));
		seemore.get(5).click();
		System.out.println("Title of the page is : " + driver.getTitle());
		 
		/*
		Thread.sleep(4000);
		//xpath using functions : parent, child, sibling-following/preceding
		driver.findElement(By.xpath("//h2[contains(text(),'Shop by Category')]//parent::div//following-sibling::div[@class='a-cardui-footer']//child::a[text()='See more']"));
		System.out.println("Title of the page is : " + driver.getTitle());
		
		*/
		//driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		//driver.findElement(By.xpath("//td[text()='Helen Bennett']//preceding-sibling::td/input[@type='checkbox']")).click();
	}

}
