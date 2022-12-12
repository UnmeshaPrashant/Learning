package TestNGControls;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGannotations {
 //ctrl+Shift+O
    
    @BeforeSuite
    public void BeforeSuite() {
        
        System.out.println("===========BeforeSuite===========");
    }
    
    @AfterSuite
    public void AfterSuite() {
        
        System.out.println("===========AfterSuite===========");
    }
    
    
    
    @BeforeTest
    public void BeforeTest() {
        
        System.out.println("===========BeforeTest===========");
    }
    
    @AfterTest
    public void AfterTest() {
        
        System.out.println("===========AfterTest===========");
    }
    
    
    @BeforeClass
    public void BeforeClass() {
        
        System.out.println("===========BeforeClass===========");
    }
    
    @AfterClass
    public void AfterClass() {
        
        System.out.println("===========AfterClass===========");
    }
    
    @BeforeMethod
    public void BeforeMethod() {
        
        System.out.println("===========BeforeMethod===========");
    }
    
    @AfterMethod
    public void AfterMethod() {
        
        System.out.println("===========AfterMethod===========");
    }
    
    @Test(priority = 1)
    public void login() {
        
        System.out.println("login test case");
        
    }
    
    @Test(priority = 3)
    public void logout() {
        
        System.out.println("logout test case");
        
    }

}
