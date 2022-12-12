package ddtNopCom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.LoginPage;
import utility.ReadConfig;

public class BaseTest {
	 WebDriver driver;
	    ReadConfig conf;
	    LoginPage lp;
	    String var1;
	    
	    //@Parameters("ibm_data")
	    @BeforeTest
	    public void launchApp() throws Exception {

	        // launching application
	        driver = new ChromeDriver();
	        
	        //var1 = data;
	        
	        driver.manage().window().maximize();

	        conf = new ReadConfig();
	        driver.get(conf.appURL());
	        
	        
	        //action 
	        Actions act = new Actions(driver);
	        //act.
	        //loginPAage
	        
	        
	        
	        //All Pages
	        //lp = new LoginPage(driver);
	        
	        
	        

	    }

	    @AfterTest
	    public void closeApp() throws Exception {

	        // close app
	        Thread.sleep(5000);
	        driver.close();
	    }


}
