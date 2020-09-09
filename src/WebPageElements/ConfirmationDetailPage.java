package WebPageElements;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import GenericClass.BaseClass;
import GenericClass.CommonWebFunctions;
import Test.TestMsgDemoApplication;
import Utils.ExcelOperations;

public class ConfirmationDetailPage extends BaseClass{
	BaseClass baseclass = new BaseClass();
	CommonWebFunctions commonwebfunction = new CommonWebFunctions();
	
	public HashMap<String,String> validateConfirmationDetails() {
		HashMap<String,String> userDetails = new HashMap<String,String>();
		int captchaAnswer = 0;
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String userName = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "UserName");
			String email = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "email");
			String firstName = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "First Name");
			String lastName = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "Last Name");
			String gender = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "Gender");
			String dob = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "Date Of Birth");
			String address = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "Address");
			String phone = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "Phone");
			String preferredContactMethod = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"),"Prefered Contact Method");
			String paymentType = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "Payment Type");
			String cardName = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "Card Holder Name");
			String cardNumber = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "Card Number");
			String expiryDate = commonwebfunction.getTextWebElementBy(baseclass.readProperty("confirmDetail", "mgsdemoproperties.properties"), "Expiry Date");
			
			
			String userNamearr[] = userName.split(":");
			String emailarr[] = email.split(":");
			String firstNamearr[] = firstName.split(":");
			String lastNamearr[] = lastName.split(":");
			String genderarr[] = gender.split(":");
			String dobarr[] = dob.split(":");
			String addressarr[] = address.split(":");
			String phonearr[] = phone.split(":");
			String preferredContactMethodarr[] = preferredContactMethod.split(":");
			String paymentTypearr[] = paymentType.split(":");
			String cardNamearr[] = cardName.split(":");
			String cardNumberarr[] = cardNumber.split(":");
			String expiryDatearr[] = expiryDate.split(":");
			
			
			
			
			userDetails.put("UserName",userNamearr[1].trim());
			userDetails.put("email",emailarr[1].trim());
			userDetails.put("First Name",firstNamearr[1].trim());
			userDetails.put("Last Name",lastNamearr[1].trim());
			userDetails.put("Password",ExcelOperations.userDetails.get("Password"));
			userDetails.put("ConfirmPassword",ExcelOperations.userDetails.get("ConfirmPassword"));
			userDetails.put("Gender",genderarr[1].trim());
			userDetails.put("Date Of Birth",dobarr[1].trim());
			userDetails.put("ProfileImageName",ExcelOperations.userDetails.get("ProfileImageName"));
			userDetails.put("Address",addressarr[1].trim());
			userDetails.put("Phone",phonearr[1].trim());
			userDetails.put("Prefered Contact Method",preferredContactMethodarr[1].trim());
			userDetails.put("Payment Type",paymentTypearr[1].trim());
			userDetails.put("Card Holder Name",cardNamearr[1].trim());
			userDetails.put("Card Number",cardNumberarr[1].trim());
			userDetails.put("CVC",ExcelOperations.userDetails.get("CVC"));
			userDetails.put("Expiry Date",expiryDatearr[1].trim());
			
			int firstDigit = Integer.parseInt(commonwebfunction.getAttribute(baseclass.readProperty("confirmdigit1", "mgsdemoproperties.properties"),"value"));
			int secondDigit = Integer.parseInt(commonwebfunction.getAttribute(baseclass.readProperty("confirmdigit2", "mgsdemoproperties.properties"),"value"));
			String operator = commonwebfunction.getTextOfElement(baseclass.readProperty("confirmoperator", "mgsdemoproperties.properties")).trim();
			String opertorarr[] = operator.split(" ");
			operator = opertorarr[opertorarr.length-2];
			
			switch(operator) {
			
			case "+": captchaAnswer =  firstDigit+secondDigit;
					break;
			case "-": captchaAnswer =  firstDigit-secondDigit;
					break;
			case "*": captchaAnswer =  firstDigit*secondDigit;
					break;
			case "/": captchaAnswer =  firstDigit/secondDigit;
					break;
			case "%": captchaAnswer =  firstDigit%secondDigit;
					break;
			}
			System.out.print("Result - "+captchaAnswer);
			commonwebfunction.sendKey(baseclass.readProperty("capchaAnswerTxtField", "mgsdemoproperties.properties"),String.valueOf(captchaAnswer));
			commonwebfunction.click(baseclass.readProperty("submitButton", "mgsdemoproperties.properties"));
			commonwebfunction.closeBrowser();
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		
		return userDetails;
		
	}

	public void closeBrowser() {
		commonwebfunction.closeBrowser();
	}
}
