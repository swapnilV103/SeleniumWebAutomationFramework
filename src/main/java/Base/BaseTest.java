package Base;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utils.Constants;

public class BaseTest {

	protected ExtentReports extent; //used to initialize and configure reports
	protected ExtentTest logger; //it will add/log each step of the testcase but it is different than a log
	private ExtentSparkReporter testreporter; //to create the actual html report file

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();




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

	public void beforeMethodMethod(String browser, Method testMethod)
	{
		WebDriver webDriver = WebDriverFactory.createDriver(browser);
		logger = extent.createTest(testMethod.getName());
		driver.set(webDriver);
		//driver.get(Constants.url);
		//driver.get().get(Constants.url);
		getDriver().get(Constants.url);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}


	public static WebDriver getDriver() 
	{
		return driver.get();
	}


	

	@AfterTest
	@AfterMethod
	public void aftertestmethod() 
	{	
		extent.flush();
		getDriver().quit();
		driver.remove();

	}

}
