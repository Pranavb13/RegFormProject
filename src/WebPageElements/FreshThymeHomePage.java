package WebPageElements;

import java.io.IOException;

import GenericClass.BaseClass;
import GenericClass.CommonWebFunctions;

public class FreshThymeHomePage extends BaseClass{

	BaseClass baseclass = new BaseClass();
	CommonWebFunctions commonwebfunction = new CommonWebFunctions();
	
	public String selectCoupons() {
		String couponName = "";
		try {
			commonwebfunction.click(baseclass.readProperty("body", "freshthymeproperties.properties"));
			commonwebfunction.mouseHoverOnElement(baseclass.readProperty("myThymeCouponsDropDown", "freshthymeproperties.properties"));
			commonwebfunction.click(baseclass.readProperty("browseCouponsButton", "freshthymeproperties.properties"));
			couponName = commonwebfunction.getTextOfElement(baseclass.readProperty("clippItem1", "freshthymeproperties.properties"));
			commonwebfunction.click(baseclass.readProperty("clippItem1", "freshthymeproperties.properties"));
			commonwebfunction.click(baseclass.readProperty("closeButton", "freshthymeproperties.properties"));
		
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		return couponName;
	}
	
	public String verifySelectedCoupon() {
		String couponName = "";
		try {
			commonwebfunction.click(baseclass.readProperty("clippedCheckBox", "freshthymeproperties.properties"));
			couponName = commonwebfunction.getTextOfElement(baseclass.readProperty("clippItem1", "freshthymeproperties.properties"));
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		return couponName;
	}
	
	public String logOut() {
		String currentURL = "";
		try {
		commonwebfunction.click(baseclass.readProperty("profileDropDown", "freshthymeproperties.properties"));
		commonwebfunction.click(baseclass.readProperty("logOutButton", "freshthymeproperties.properties"));
		commonwebfunction.click(baseclass.readProperty("closeButton", "freshthymeproperties.properties"));
		currentURL = commonwebfunction.getCurrentURL();
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		return currentURL;
			
	}
	
}
