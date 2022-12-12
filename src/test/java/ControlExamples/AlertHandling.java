package ControlExamples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcomm.BaseClass;

public class AlertHandling extends BaseClass {

	@Test(priority=1)
	public void HandleSimpleAlert() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
		Thread.sleep(3000);
		Alert simpleAlert = driver.switchTo().alert();
		
		String simpleAlertText = simpleAlert.getText();
		System.out.println("Simple Alert text is : "+simpleAlertText);
		Assert.assertEquals(simpleAlertText, "Hi.. This is alert message!");
		Assert.assertTrue(simpleAlertText.contains("alert message"));
		
		simpleAlert.accept();
		
	}
	
	@Test(priority=2)
	public void HandleConfirmAlert() throws InterruptedException 
	{
		driver.findElement(By.xpath("//button[contains(text(),'Show Me Confirmation')]")).click();
		Thread.sleep(3000);
		Alert confirmAlert= driver.switchTo().alert();
		String confirmALertText = confirmAlert.getText();
		Assert.assertEquals(confirmALertText, "Press 'OK' or 'Cancel' button!");
		Assert.assertTrue(confirmALertText.contains("Cancel"));
		confirmAlert.dismiss();
		String confirmStatus=driver.findElement(By.xpath("//div[@id='demo']")).getText();
		System.out.println("Confirm Alert status : "+confirmStatus);
	}

	@Test(priority=3)
	public void HandlePromptAlert() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Show Me Prompt')]")).click();
		Alert promptAlert=driver.switchTo().alert();
		Thread.sleep(3000);
		promptAlert.sendKeys("Unmesha");
		Thread.sleep(2000);
		promptAlert.accept();
	}
}
