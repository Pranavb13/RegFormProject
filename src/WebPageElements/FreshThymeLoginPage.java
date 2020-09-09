package WebPageElements;

import java.io.IOException;

import GenericClass.BaseClass;
import GenericClass.CommonWebFunctions;

public class FreshThymeLoginPage extends BaseClass{

	BaseClass baseclass = new BaseClass();
	CommonWebFunctions commonwebfunction = new CommonWebFunctions();
	
	public String loginToFreshThyme(String loginID, String password) {
		String status = "Failed";
		try {
			commonwebfunction.click(baseclass.readProperty("closeButton", "freshthymeproperties.properties"));
			commonwebfunction.click(baseclass.readProperty("loginButton", "freshthymeproperties.properties"));
			commonwebfunction.sendKey(baseclass.readProperty("loginIdTxtField", "freshthymeproperties.properties"),loginID);
			commonwebfunction.sendKey(baseclass.readProperty("passwordTxtField", "freshthymeproperties.properties"),password);
			commonwebfunction.click(baseclass.readProperty("signInButton", "freshthymeproperties.properties"));
			status = "Success";
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		
		return status;
	}
	
	public void closeBrowser() {
		commonwebfunction.closeBrowser();
	}
	
	
}
