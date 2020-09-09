package Test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GenericClass.BaseClass;
import WebPageElements.FreshThymeHomePage;
import WebPageElements.FreshThymeLoginPage;
import junit.framework.Assert;

public class TestfreshthymeApplication {

	BaseClass baseClass = new BaseClass();
	FreshThymeHomePage freshThymeHomePage = new FreshThymeHomePage();
	FreshThymeLoginPage freshThymeLoginPage = new FreshThymeLoginPage();
	
	
	@SuppressWarnings("deprecation")
	@BeforeTest
    public void launchBrowser() throws IOException, InterruptedException {
	     String baseUrl = baseClass.readProperty("freshThymeURL", "projectProperties.properties");
	     String browserDriver = baseClass.readProperty("chromeDriver", "projectProperties.properties");
	     baseClass.initializeBrowser(browserDriver);
	     baseClass.navigateToURL(baseUrl);
    }
	
	@Test
	public void login() throws IOException {
		Assert.assertEquals("Success",freshThymeLoginPage.loginToFreshThyme("James.Tester@bullara.com", "PA28-161"));
		Assert.assertEquals(freshThymeHomePage.selectCoupons(), freshThymeHomePage.verifySelectedCoupon());
		Assert.assertEquals("https://discover.freshthyme.com/", freshThymeHomePage.logOut());
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		freshThymeLoginPage.closeBrowser();
	}
	
	
}
