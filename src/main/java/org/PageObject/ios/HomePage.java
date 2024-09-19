package org.PageObject.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.IOS_Actions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends IOS_Actions{

	IOSDriver driver;
	public HomePage(IOSDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertView;
	
	public Alert_View selectalertView() {
		alertView.click();
		return new Alert_View(driver);
	}
	
}
