package com.nopcomm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig;

public class BaseClass {
	public WebDriver driver;
	public ReadConfig conf;

	@Parameters("ibm_browser")
	@BeforeTest
	public void launchApp(String browser) throws Exception {
		
		System.out.println("Execution on browser: " + browser);

		//driver = WebDriverManager.chromedriver().create();
		//driver = WebDriverManager.edgedriver().create();

		if (browser.equalsIgnoreCase("CHROME")) {

			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}
		/*
		 * else {
		 * 
		 * System.out.println("execution on defaul browser: " + browser); //default
		 * execution on chrome browser driver = new ChromeDriver(); }
		 */

		// cntrl+shift+o ..... auto import shortcut
		System.out.println("***Launching an Application***");

		conf = new ReadConfig();
		System.out.println(conf.appURL());
		driver.get(conf.appURL());
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("***Closing an Application***");
		driver.close();
	}
}
