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
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected ExtentReports extent; //used to initialize and configure reports
    protected ExtentTest logger; //it will add/log each step of the testcase but it is different than a log
    private ExtentSparkReporter testreporter; //to create the actual html report file

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private WebDriverWait wait;

    @BeforeTest
    public void beforeTestMethod() {
        testreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReport.html");
        testreporter.config().setDocumentTitle("Test Automation Report");
        testreporter.config().setReportName("Selenium Web Automation Framework Report");
        testreporter.config().setTheme(Theme.DARK);
        
      
        //protected ExtentReports extent = new ExtentReports();  This is actually the object of the class; which could have been defined this way but we did by declaring variables first
        extent = new ExtentReports();
        extent.attachReporter(testreporter);

        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Automation QA", "Your Name");
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethodMethod(@Optional("chrome") String browser, Method testMethod) {
        setupDriver(browser);
        logger = extent.createTest(testMethod.getName());
        getDriver().get(Constants.url);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod
    public void aftertestmethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
        }

        getDriver().quit();
        driver.remove();
    }

    @AfterTest
    public void aftertestmethodone() {
        System.out.println("All tests are completed!");
        extent.flush();
    }

    public void setupDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
