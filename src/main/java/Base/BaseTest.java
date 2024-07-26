package Base;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utils.Constants;
import Utils.ElementFetch;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected ExtentReports extent; //used to initialize and configure reports
	protected ExtentTest logger; //it will add/log each step of the testcase but it is different than a log
	private ExtentSparkReporter testreporter; //to create the actual html report file

	//private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static WebDriver driver;
	WebDriverWait wait;




	@BeforeTest
	public void beforeTestMethod() 
	{

		testreporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/ExtentReport.html");
		testreporter.config().setDocumentTitle("Test Automation Report");
		testreporter.config().setReportName("Selenium Web Automation Framework Report");
		testreporter.config().setTheme(Theme.DARK);


		//protected ExtentReports extent = new ExtentReports();  This is actually the object of the class; which could have been defined this way but we did by declaring variables first
		extent = new ExtentReports();
		extent.attachReporter(testreporter);

		//System Information
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Automation QA", "Swapnil Vidhate");	
		

	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethodMethod(@Optional("chrome") String browser, Method testMethod)
	{
		setupDriver(browser);
		logger = extent.createTest(testMethod.getName());
		//webDriver.get(Constants.url);
		//driver.set(webDriver);
		//driver.get(Constants.url);
		//driver.get().get(Constants.url);
		driver.get(Constants.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//getDriver().get(Constants.url);
		//getDriver().manage().window().maximize();
		//getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}


	//public static WebDriver getDriver() 
	//{
	//driver = driver.get();
	//return driver.get();
	//}





	@AfterMethod
	public void aftertestmethod(ITestResult result) 
	{	
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"- Test Case Failed = ",ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"- Test Case Failed = ",ExtentColor.RED));
		}
		if(result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"- Test Case Skipped = ",ExtentColor.ORANGE));
		}
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"- Test Case Passed= ",ExtentColor.GREEN));

		}	
		//extent.flush();
		//getDriver().quit();
		//driver.remove();
		driver.quit();
	}


	@AfterTest
	public void aftertestmethodone() {
		System.out.println("All tests are completed!");

		// Close the report
		extent.flush();
	
	}



	public void setupDriver(String browser) {

		if(browser.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();		
		}
		if(browser.equalsIgnoreCase("firefox")) {
			//WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();		
		}
	}




}
