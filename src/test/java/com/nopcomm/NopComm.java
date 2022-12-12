package com.nopcomm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NopComm extends BaseClass{
	
	
	@Test
    public void verifyLogin() throws InterruptedException
    {
		
		WebElement username = driver.findElement(By.id("Email")); //username
		username.clear();
		username.sendKeys(conf.getEmail());
		
		WebElement password = driver.findElement(By.id("Password")); //password
		password.clear();
		password.sendKeys(conf.getPass());
		
		driver.findElement(By.xpath("//button[@type='submit']")).click(); //click on Login
		
		Thread.sleep(4000);
		//xpath using indexing
		/*
		List <WebElement> customer =driver.findElements(By.xpath("//p[contains(text(),'Customers')]"));
		customer.get(0).click(); // Expand Customers
		Thread.sleep(2000);
		customer.get(1).click(); // Click on Customers
		*/
		
		//xpath not using index, use functions
		driver.findElement(By.xpath("//a[contains(@href,'#')]//p[contains(text(),'Customers')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,\"/Admin/Customer/List\")]//child::p[contains(text(),'Cus')]")).click();
    }

}
