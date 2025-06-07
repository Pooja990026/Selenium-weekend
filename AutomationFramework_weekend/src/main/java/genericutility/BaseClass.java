package genericutility;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.Homepage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass {

	public static ExtentReports eReports;
	public static WebDriver driver;
	
	
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public FileUtility fUtil=new FileUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	
	@BeforeSuite
	public void reportconfig() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML.reports/extentReport_"+jUtil.getSystemTime()+".html");
	    eReports=new ExtentReports();
	    eReports.attachReporter(spark);
	}
	
	@BeforeClass
	public void openBrowser() throws IOException {
		ChromeDriver driver = new ChromeDriver();
		wUtil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(fUtil.getDataFromProperty("url"));
	}
	@BeforeMethod
	public void login() throws IOException {
		WelcomePage wp=new WelcomePage(driver);
		wp.getLoginLink().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getEmailTextfield().sendKeys(fUtil.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("passwotrd"));
		lp.getLoginButton().click();
	}
	
	@AfterMethod
	public void logout() {
		Homepage hp=new Homepage(driver);
		hp.getLogoutLink().click();
	}
	
	@AfterSuite
	public void reportBackup() {
		eReports.flush();
	}
}
