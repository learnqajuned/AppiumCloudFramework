package org.PageObject.android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;
import org.utils.AppiumUtils;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class FormPage extends AppiumUtils {

	AndroidDriver driver;
	public FormPage(AndroidDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	

	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement MaleOption;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement submitButton;
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setCountrySelection(String name) {
		countrySelection.click();
	//	ScrollToText(name);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+name+"']")).click();
	}
	public void setGender(String gender) {
		if(gender.contains("female")) {
			femaleOption.click();
		}else {
			MaleOption.click();
		}
	}
	//we write one Utility method which actually scan this json file and inject here.
	public ProductCatalogue submitForm() {
		submitButton.click();
		return new ProductCatalogue(driver);
	}
	public void setActivity() {

		Activity act=new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
	//	driver.startActivity(act);
		((JavascriptExecutor)driver).executeScript("mobile : startActivity",
				ImmutableMap.of("intent","u0io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		
	}
}
//How to drive the data from Json files and load into Hashmap for parameterization.