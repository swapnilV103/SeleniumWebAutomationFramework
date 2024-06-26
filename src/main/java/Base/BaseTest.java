package Base;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	
	protected ExtentReports extent; //used to initialize and configure reports
	protected ExtentTest test; //it will add each step of the testcase
	private ExtentSparkReporter testreporter; //to create the actual html report file
	

	

@BeforeTest
public Void beforeTestMethod() {
	
	testreporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/ExtentReport.html");
	testreporter.config().setDocumentTitle("Test Automation Report");
	testreporter.config().setReportName("Selenium Web Automation Framework Report");
	testreporter.config().setTheme(Theme.DARK);
	
	extent = new ExtentReports();
	extent.attachReporter(testreporter);
	return null;
	
	
	
}

@BeforeMethod
@AfterTest
@AfterMethod
public Void aftertestmethod() {
	return null;
	
}

}
