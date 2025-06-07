package genericutility;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.html.HTMLFrameElement;

public class WebDriverUtility {

	private static final String frameElement = null;

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void captureSize(WebDriver driver) {
		driver.manage().window().getSize();
	
	}
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
	}
	
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void selectDropdownByIndex(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectDropdownByValue(WebElement element, String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
}
	public void selectDropdownByText(WebElement element, String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(frameElement);
	}
	public void switchBackToHome(WebDriver driver) {
		driver.switchTo().alert();
	}
	
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public void getPhoto(WebDriver driver) {
		JavaUtility jUtil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot) driver;
  File temp=ts.getScreenshotAs(OutputType.FILE);
  
		
	}
}

