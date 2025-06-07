package books;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import objectrepository.Homepage;

public class TC_DWS_001_Test extends BaseClass {

	@Test
	public void clickonBooks() {
	
		ExtentTest test=eReports.createTest("clickonBooks");
		Homepage hp=new Homepage(driver);
		hp.getBooksLink().click();
		Assert.assertEquals(driver.getCurrentUrl(),"https://demowebshop.tricentis.com/books");
		test.log(Status.PASS,"Book page is dispalyed");
}
}
