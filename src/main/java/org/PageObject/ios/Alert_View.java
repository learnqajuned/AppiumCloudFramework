package org.PageObject.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.IOS_Actions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Alert_View extends IOS_Actions{

	IOSDriver driver;
	public Alert_View(IOSDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUITElementStaticText[`label=='Text Entry'`]")
	private WebElement textEntryMenu;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUITElementTypeCell")
	private WebElement textBox;
	
	@iOSXCUITFindBy(iOSNsPredicate="type=='XCUITElementStaticText' AND value BEGINSWITH[c] 'Conform'")
	private WebElement conformMenuItems;
	
	@iOSXCUITFindBy(iOSNsPredicate="name BEGINSWITH[c] 'A message'")
	private WebElement conformMessage;
	
	@iOSXCUITFindBy(iOSNsPredicate="label =='Conform'")
	private WebElement submit;
	
	@iOSXCUITFindBy(accessibility="Ok")
	private WebElement acceptPopup;
	
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertView;
	
	public void fillLabelText(String name) {
		textEntryMenu.click();
		textBox.sendKeys(name);
		acceptPopup.click();
	}
	public Alert_View selectalertView() {
		alertView.click();
		return new Alert_View(driver);
	}
	
	public String getConformMessage() {
		conformMenuItems.click();
		return conformMessage.getText();
	}
	public void submit() {
		submit.click();
	}
}
