package GenericClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonWebFunctions extends BaseClass{
	
	
	public void click(String xpath) {
		
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
	}
	
	public void sendKey(String xpath,String value) {
		
		WebElement element = driver.findElement(By.xpath(xpath));
		element.sendKeys(value);
	}
	
	public WebElement getWebElement(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public void waitForVisibilityOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public List<WebElement> getListOfWebElements(String xpath) {
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements;		
	}
	
	public void waitForPageToLoad() throws InterruptedException {
		Thread.sleep(3000);
	}
	

	public void selectOptionFromDropDownByValue(String xpath, String value) {
		click(xpath);
		Select select = new Select(getWebElement(xpath));
		select.selectByValue(value);
	}

	public String getTextOfElement(String xpath) {
		return getWebElement(xpath).getText();
	}
	
	public void pasteContent() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
	}
	
	public void pressEnterKey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void copyContent(String text) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(text);
		clipboard.setContents(stringSelection, null);
	}
	
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void mouseHoverOnElement(String xpath) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(xpath)).build().perform();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public void pseudoEleemntClick(String xpath) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("document.querySelector('"+xpath+"',':before').click();");
	}
	
	public String getAttribute(String xpath, String attributeName) {
		return getWebElement(xpath).getAttribute(attributeName);
	}


	public void closeBrowser() {
		driver.quit();
		
	}

	public String getTextWebElementBy(String xpath, String value) {
		return driver.findElement(By.xpath(xpath.replace("$value", value))).getText();
	}
	
	public void takeErrorScreenshot() {
		File destFile = new File(System.getProperty("user.dir")+"\\target\\errorScreenShot.png");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void implicitilyWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
}
