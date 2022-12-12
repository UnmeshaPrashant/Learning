package ddtNopCom;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NOPCommLoginTest extends BaseTest{
	 @Test(dataProvider = "regressionData")
	    public void verifyLoginWithInValidUser(String email, String pwd) throws Exception {
	        
	        Thread.sleep(3000);
	        driver.findElement(By.id("Email")).clear();
	        driver.findElement(By.id("Email")).sendKeys(email);
	        Thread.sleep(3000);
	        driver.findElement(By.id("Password")).clear();
	        driver.findElement(By.id("Password")).sendKeys(pwd);
	        Thread.sleep(3000);
	        driver.findElement(By.id("RememberMe")).click();
	        driver.findElement(By.tagName("button")).click();
	        
	        
	        //Validation Step
	        String errorMessagePage = driver.getPageSource();
	        System.out.println(errorMessagePage);
	        Assert.assertTrue(errorMessagePage.contains("Login was unsuccessful."));
	        
	        
	    }

	    
	    
	    @DataProvider
	    public Object[][] sampleData() {
	        
	        Object [][] data = {{"abirami@google.com","demo@123"}, {"Kritika@yahoo.com","password"}, {"Priyanka@gmail.com","password"}};
	        
	        
	        return data;
	    }
	    
	    
	    @DataProvider
	    public Object[][] regressionData() {
	        
	        Object [][] data = {{"abiramiRegsssion@google.com","demo@123"}, {"KritikaRegsssion@yahoo.com","password"}, {"PriyankaRegsssion@gmail.com","password"}, {"sidRegsssion@gmail.com","password"}};
	        
	        
	        return data;
	    }
	    
	    

}
