package Apptest.AppiumAppFramework;

import org.PageObject.ios.Alert_View;

import junit.framework.Assert;

public class IOS_Test extends IOS_Base_Utility{

	public void IOSTest() {
		Alert_View alert=homePage.selectalertView();
		alert.fillLabelText("Hello");
		String actualMessage=alert.getConformMessage();
		Assert.assertEquals(actualMessage, "A message should be short, complete sentence");
		//alert.submit();
		
	}
}
