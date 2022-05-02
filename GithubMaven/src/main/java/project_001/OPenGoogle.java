package project_001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class OPenGoogle {

	public static void main(String[] args) {


		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter report = new ExtentSparkReporter("C:\\Users\\naveen\\Desktop\\Selenium WorkSpace\\GithubDemoProject\\reports\\Reports.html");
		report.config().setTheme(Theme.DARK);
		report.config().setDocumentTitle("Automation Testing");
		report.config().setReportName("ExtentReport");
		extent.attachReporter(report);

		ExtentTest test = extent.createTest("LoginTest").assignAuthor("jayakrishna").assignCategory("smoke").assignDevice("windows");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\naveen\\Desktop\\SeleniumComplete\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("jayakrishna Thiruvarangam");
		driver.findElement(By.name("q")).submit();

		test.pass("Login Test Passed Successfully");
		test.info("URL Loaded successfully");
		test.info("Values entered Successfully");
		test.pass("Login Test Completed Successfully");

		ExtentTest test1 = extent.createTest("HomePageTest").assignAuthor("Ashwath").assignAuthor("Deepa").assignCategory("Regresstion");
		test1.pass("HomePageTest Passed Successfully");
		test1.info("URL Loaded successfully");
		test1.info("Values entered Successfully");
		test1.fail("Login Test failed Miserably");
		driver.quit();
		extent.flush();	
	}

}


