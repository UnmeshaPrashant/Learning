package extentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	public WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;
    
	
	@BeforeTest
	public void startReport()
	{
		
		 String date_num =new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        System.out.println(date_num);
	        ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("./test-output/extentReport/IBM_ExtentReport_" + date_num +".html");
	        
	        //Create an Object of Extent Report
	        extent = new ExtentReports();
	        
	        extent.attachReporter(htmlReport);
	        
	        //Custom Report
	        
	        extent.setSystemInfo("Host Name", "Localhost");
	        extent.setSystemInfo("Enviornment", "Production");
	        extent.setSystemInfo("ExecutedBy", "Unmesha Prashant");
	        extent.setSystemInfo("Automation", "Functional/API");
	        
	        htmlReport.config().setDocumentTitle("IBM - functional automation/Api automation");
	        htmlReport.config().setReportName("Regression Report");
	        htmlReport.config().setTheme(Theme.DARK);
		
	}
	// This method is to capture the screenshot and return the path of the
    // screenshot.
    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        
        
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        
        // after execution, you could see a folder "FailedTestsScreenshots" under src
        // folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        
        
        return destination; // to attach this screenshot to extent report, return it
    }
    
    @BeforeMethod
    public void setup() {
        // System.setProperty("webdriver.chrome.driver","C://AutomationFramework//Drivers//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }
    @Test
    public void verifyTitle() {
        logger = extent.createTest("To verify Google Title"); // this title will be added for each test and will be seen on extent report on browser
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void verifyLogo() {
        logger = extent.createTest("To verify Google Logo");
        
        boolean img = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
        
        logger.createNode("Image is Present");  //node will add details in the test in extent report and seen on browser 
        Assert.assertTrue(img);
        logger.createNode("Image is not Present");
        Assert.assertFalse(img);
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            // MarkupHelper is used to display the output in different colors
            logger.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED)); 
            // result.getName() will print the method name in extent report, which method is failed
            
            logger.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            //To print the exception in extent report : result.getThrowable()
            
            // To capture screenshot path and store the path of the screenshot in the string
            // "screenshotPath"
            // We do pass the path captured by this method in to the extent reports using
            // "logger.addScreenCapture" method.
            // String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
            String screenshotPath = getScreenShot(driver, result.getName());
            
        
            // To add it in the extent report
            logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
            
            
        } 
        else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
            
            
            
            String screenshotPath = getScreenShot(driver, result.getName());
            // To add it in the extent report
            logger.fail("Test Case Passed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
            
            
        } 
        else if (result.getStatus() == ITestResult.SUCCESS) {
            
            
//          String screenshotPath = getScreenShot(driver, result.getName());
//          logger.pass("Test Case pass Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
            logger.log(Status.PASS,
                    MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        }
        driver.quit();
    }

	
	@AfterTest
	public void endReport()
	{
		extent.flush(); //flush is for writing details to the report. Same as .perform() in Action class
	}

}
