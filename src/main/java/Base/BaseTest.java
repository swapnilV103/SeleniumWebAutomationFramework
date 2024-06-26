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
	
	
	//protected ExtentReports extent = new ExtentReports();  This is actually the object of the class which could have been defined this way but we did by declaring variables first
	extent = new ExtentReports();
	extent.attachReporter(testreporter);
	
	//System Information
	extent.setSystemInfo("OS", "Windows");
	extent.setSystemInfo("Automation QA", "Swapnil Vidhate");
	
	return null;
	
	
	
}

@BeforeMethod
@AfterTest
@AfterMethod
public Void aftertestmethod() {
	return null;
	
}

}
