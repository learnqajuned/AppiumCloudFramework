package org.PageObject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {

	AndroidDriver driver;
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement term;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	public List<WebElement> getProductList(){
		return productList;
	}
	
	public double getProductSum() {
		int count=productList.size();
		double totalsum=0;
		for(int i=0;i<count;i++) {
			String AmountString=productList.get(i).getText();
			//Double price=Double.parseDouble(AmountString.substring(1));
			Double price= getformattedAmount(AmountString);
			totalsum=totalsum+price; 
	}
	return totalsum;
	}
	
	public double getTotalAmountDisplayed() {
		return getformattedAmount(totalAmount.getText());
	}
	
	public void acceptTermsConditions() {
		LongPressAction(term);
		acceptButton.click();
		
	}
	public Double getFormattedAmount(String amount) {
		Double price=Double.parseDouble(amount.substring(1));
		return price;
	}
	public void submitOrder() {
		checkBox.click();
		proceed.click();
	}
}
