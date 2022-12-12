package nopCommLog4J;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utility.ReadConfig;

public class BaseClass {
	public WebDriver driver;
	public ReadConfig conf;
	Logger log;

	@Parameters("ibm_browser")
	@BeforeTest
	public void launchApp(String browser) throws Exception {
		

        log = Logger.getLogger("NOP Comm Application Module");
        PropertyConfigurator.configure(".\\TestData\\log4j.properties");
        
        log.info("launching applicaiton on browser : " + browser);
		
		//System.out.println("Execution on browser: " + browser);

		//driver = WebDriverManager.chromedriver().create();
		//driver = WebDriverManager.edgedriver().create();

		if (browser.equalsIgnoreCase("CHROME")) {

			driver = new ChromeDriver();
			log.info("browser launched");
		}

		else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
			log.info("browser launched");
		}
		/*
		 * else {
		 * 
		 * System.out.println("execution on defaul browser: " + browser); //default
		 * execution on chrome browser driver = new ChromeDriver(); }
		 */

		// cntrl+shift+o ..... auto import shortcut
		System.out.println("***Launching an Application***");
		//create an object of configRead
		conf = new ReadConfig();
		//System.out.println(conf.appURL());
		log.info("Application URL " + conf.appURL());
		driver.get(conf.appURL());
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("***Closing an Application***");
		log.info("closing app");
		driver.close();
	}
}
