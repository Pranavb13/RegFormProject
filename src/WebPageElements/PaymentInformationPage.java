package WebPageElements;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import GenericClass.BaseClass;
import GenericClass.CommonWebFunctions;

public class PaymentInformationPage extends BaseClass{
	BaseClass baseclass = new BaseClass();
	CommonWebFunctions commonwebfunction = new CommonWebFunctions();
	
	public String enterPaymentDetails(String paymentType, String cardHolderName, String cardNumber, String cvc, String expiryDate) {
		String status = "Failed";
	try {
			commonwebfunction.implicitilyWait(20);
			commonwebfunction.selectOptionFromDropDownByValue(baseclass.readProperty("paymentTypeDropDown", "mgsdemoproperties.properties"),paymentType);
			commonwebfunction.sendKey(baseclass.readProperty("cardHolderNameTxtField", "mgsdemoproperties.properties"),cardHolderName);
			commonwebfunction.sendKey(baseclass.readProperty("cardNumberTxtField", "mgsdemoproperties.properties"),cardNumber);
			commonwebfunction.sendKey(baseclass.readProperty("cvcTxtField", "mgsdemoproperties.properties"),cvc);
			commonwebfunction.sendKey(baseclass.readProperty("expiryDateTxtField", "mgsdemoproperties.properties"),expiryDate);
			commonwebfunction.click(baseclass.readProperty("paymentdetailsBody", "mgsdemoproperties.properties"));
			commonwebfunction.pseudoEleemntClick(baseclass.readProperty("agreetc", "mgsdemoproperties.properties"));
			commonwebfunction.click(baseclass.readProperty("paymentinfoNextButton", "mgsdemoproperties.properties"));
		status = "Success";
	}catch(Exception e) {
		commonwebfunction.takeErrorScreenshot();
		e.printStackTrace();
	}
	return status;
	
	}
	

}
