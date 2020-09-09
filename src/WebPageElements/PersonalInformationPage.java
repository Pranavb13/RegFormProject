package WebPageElements;

import GenericClass.BaseClass;
import GenericClass.CommonWebFunctions;
import java.lang.*;
import java.util.concurrent.TimeUnit;

public class PersonalInformationPage extends BaseClass{

	BaseClass baseclass = new BaseClass();
	CommonWebFunctions commonwebfunction = new CommonWebFunctions();
	
	public String enterPersonalPageInformation(String firstName, String lastName, String gender, String dateOfBith, String address, String phoneNumber, String contactMethod,String profilePicName){
		String status = "Failed";
		try {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				commonwebfunction.sendKey(baseclass.readProperty("fnameTxtField", "mgsdemoproperties.properties"),firstName);
				commonwebfunction.sendKey(baseclass.readProperty("lnameTxtField", "mgsdemoproperties.properties"),lastName);
				commonwebfunction.selectOptionFromDropDownByValue(baseclass.readProperty("genderDropDown", "mgsdemoproperties.properties"),gender);
				commonwebfunction.sendKey(baseclass.readProperty("birthdateTxtField", "mgsdemoproperties.properties"),dateOfBith);
				commonwebfunction.sendKey(baseclass.readProperty("addressTxtField", "mgsdemoproperties.properties"),address);
				commonwebfunction.sendKey(baseclass.readProperty("phoneTxtField", "mgsdemoproperties.properties"),phoneNumber);
				commonwebfunction.click(baseclass.readProperty("contactMethod", "mgsdemoproperties.properties").replace("$value", contactMethod));
				commonwebfunction.click(baseclass.readProperty("browseButton", "mgsdemoproperties.properties"));
				commonwebfunction.copyContent(profilePicName);
				commonwebfunction.waitForPageToLoad();
				commonwebfunction.pasteContent();
				commonwebfunction.waitForPageToLoad();
				commonwebfunction.pressEnterKey();
				commonwebfunction.waitForPageToLoad();
				commonwebfunction.click(baseclass.readProperty("personalinfoNextButton", "mgsdemoproperties.properties"));
				commonwebfunction.waitForPageToLoad();
			status = "Success";
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		return status;
	}
}
