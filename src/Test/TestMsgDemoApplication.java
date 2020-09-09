package Test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GenericClass.BaseClass;
import Utils.ExcelOperations;
import WebPageElements.AccountInformationPage;
import WebPageElements.ConfirmationDetailPage;
import WebPageElements.PaymentInformationPage;
import WebPageElements.PersonalInformationPage;
import junit.framework.Assert;

public class TestMsgDemoApplication {

	BaseClass baseClass = new BaseClass();
	AccountInformationPage accountinfopage = new AccountInformationPage();
	PersonalInformationPage personalInfoPage = new PersonalInformationPage();
	PaymentInformationPage paymentinfopage = new PaymentInformationPage();
	ConfirmationDetailPage confirmationdetailpage = new ConfirmationDetailPage();

	
	  @Test 
	  public void testAccountInformatioPage() throws IOException,InterruptedException {
		  
		  for(int rowNumber = 1;rowNumber<=ExcelOperations.getNumberOfRowsOfExcel("InputExcel.xlsx", "UserDetails");rowNumber++) {
			  HashMap<String,String> userDetails = new HashMap<String,String>();
			  String baseUrl = baseClass.readProperty("regFormURL", "projectProperties.properties");
			  String browserDriver = baseClass.readProperty("chromeDriver", "projectProperties.properties");
			  baseClass.initializeBrowser(browserDriver);
			  baseClass.navigateToURL(baseUrl);
			  userDetails = ExcelOperations.readExcelForInputData("InputExcel.xlsx", "UserDetails", rowNumber);
			  Assert.assertEquals("Success",accountinfopage.enterAccountPageInformation(userDetails.get("UserName"), userDetails.get("email"), userDetails.get("Password"), userDetails.get("ConfirmPassword")));
			  Assert.assertEquals("Success",personalInfoPage.enterPersonalPageInformation(userDetails.get("First Name"), userDetails.get("Last Name"),
					  userDetails.get("Gender"),userDetails.get("Date Of Birth"), userDetails.get("Address"),userDetails.get("Phone"),userDetails.get("Prefered Contact Method"),userDetails.get("ProfileImageName"))); 
			  Assert.assertEquals("Success",paymentinfopage.enterPaymentDetails(userDetails.get("Payment Type"), userDetails.get("Card Holder Name"),userDetails.get("Card Number"),userDetails.get("CVC"),userDetails.get("Expiry Date"))); 
			  HashMap<String,String> contactDetailsMap = new HashMap<String,String>();
			  contactDetailsMap = confirmationdetailpage.validateConfirmationDetails();
			  contactDetailsMap.put("Date Of Birth",contactDetailsMap.get("Date Of Birth").replace(",", ""));
			  contactDetailsMap.put("Expiry Date",contactDetailsMap.get("Expiry Date").replace(",", ""));
			  userDetails.put("Date Of Birth",contactDetailsMap.get("Date Of Birth").replace(",", ""));
			  userDetails.put("Expiry Date",contactDetailsMap.get("Expiry Date").replace(",", ""));
			  Assert.assertTrue(contactDetailsMap.equals(userDetails));
		  }
	  }
	 
	
	 

}
