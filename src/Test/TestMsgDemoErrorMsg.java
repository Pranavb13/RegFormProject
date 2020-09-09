package Test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GenericClass.BaseClass;
import Utils.ExcelOperations;
import WebPageElements.AccountInformationPage;
import WebPageElements.ConfirmationDetailPage;
import WebPageElements.PaymentInformationPage;
import WebPageElements.PersonalInformationPage;

public class TestMsgDemoErrorMsg {
	
	
	BaseClass baseClass = new BaseClass();
	AccountInformationPage accountinfopage = new AccountInformationPage();
	PersonalInformationPage personalInfoPage = new PersonalInformationPage();
	PaymentInformationPage paymentinfopage = new PaymentInformationPage();
	ConfirmationDetailPage confirmationdetailpage = new ConfirmationDetailPage();
	
	
	@SuppressWarnings("deprecation")
	  
	  @BeforeMethod 
	  public void launchBrowser() { 
		 String baseUrl ="https://mgsdemo.mgscoder.com/mgscode/regform/index-2.html"; 
		 String status = baseClass.launchPage(baseUrl); 
		 Assert.assertEquals("Success", status); 
		 }
	 

	
	  @Test 
	  public void numberOfForms() throws IOException { 
	    int numberOfForms = accountinfopage.getNumberOfForms();
	    System.out.println("Number of Forms on Wizard - " + numberOfForms);
	    Assert.assertEquals(4, numberOfForms); 
	    
	  }
	 
	
	  @Test
	  public void testInvalidData() {
		  Assert.assertEquals("Success",accountinfopage.enterAccountPageInformation("pranav", "p@gmail.com", "", "")); 
		  String message = accountinfopage.getSuccessMessage(); 
		  System.out.println("--"+message);
		  Assert.assertEquals("Please Fill the Form Properly!",message); 
		  
	  }
	 
	
	  @Test 
	  public void testErrorMessages() throws IOException {
		  Assert.assertEquals("Success",accountinfopage.enterAccountPageInformation("","", "", "")); 
		  List<String> dataUI = accountinfopage.getErrorMessages();
		  List<String> dataexcel = ExcelOperations.readExcel("InputExcel.xlsx","ErrorMessages");
		  System.out.println("UI"+dataUI); System.out.println("excel"+dataexcel);
		  Assert.assertTrue(dataUI.equals(dataexcel)); 
	  
	  }
	  
	  @AfterMethod
	  public void closeConnections() {
		  confirmationdetailpage.closeBrowser();
	  }
	 

}
