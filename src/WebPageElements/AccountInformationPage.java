package WebPageElements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericClass.BaseClass;
import GenericClass.CommonWebFunctions;

public class AccountInformationPage extends BaseClass{

	//WebDriver driver = BaseClass.browserDriver.get("Driver");
	BaseClass baseclass = new BaseClass();
	CommonWebFunctions commonwebfunction = new CommonWebFunctions();
	
	
	public String enterAccountPageInformation(String userName,String email, String password, String confirmPassword) {
		String status = "Failed";
		try {
			commonwebfunction.sendKey(baseclass.readProperty("usernameTxtField", "mgsdemoproperties.properties"),userName);
			commonwebfunction.sendKey(baseclass.readProperty("emailTxtField", "mgsdemoproperties.properties"),email);
			commonwebfunction.sendKey(baseclass.readProperty("passwordTxtField", "mgsdemoproperties.properties"),password);
			commonwebfunction.sendKey(baseclass.readProperty("confirmpasswordTxtField", "mgsdemoproperties.properties"),confirmPassword);
			commonwebfunction.click(baseclass.readProperty("accountinfoNextButton", "mgsdemoproperties.properties"));
			status = "Success";
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		
		return status;
	}


	public int getNumberOfForms() {
		int numberOfForms = 0;
		try {
			numberOfForms = commonwebfunction.getListOfWebElements(baseclass.readProperty("numberOfForms", "mgsdemoproperties.properties")).size();
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		return numberOfForms;
	}


	public String getSuccessMessage() {
		String message = null;
		try {
			message = commonwebfunction.getTextOfElement(baseclass.readProperty("accountPageErrorMessage", "mgsdemoproperties.properties"));
			commonwebfunction.click(baseclass.readProperty("confirmButton", "mgsdemoproperties.properties"));
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		
		return message;
	}


	public List<String> getErrorMessages() {
		List<String> errorMsg = new ArrayList<String>();
		try {
			commonwebfunction.click(baseclass.readProperty("confirmButton", "mgsdemoproperties.properties"));
			errorMsg.add( commonwebfunction.getTextOfElement(baseclass.readProperty("userNameErrorMsg", "mgsdemoproperties.properties")));
			errorMsg.add( commonwebfunction.getTextOfElement(baseclass.readProperty("emailErrorMsg", "mgsdemoproperties.properties")));
			errorMsg.add( commonwebfunction.getTextOfElement(baseclass.readProperty("passwordErrorMsg", "mgsdemoproperties.properties")));
			
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		return errorMsg;
		
	}

}
