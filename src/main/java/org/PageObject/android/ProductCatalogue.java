package org.PageObject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//GrandParent(AppiumUtils) --> AndroidActions -->ProductCatalogue..
public class ProductCatalogue {

	AndroidDriver driver;
	public ProductCatalogue(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	public void addToCartByIndex(int index) {
		addToCart.get(index).click();
	}
	public CartPage goToCart() throws InterruptedException {
		cart.click();
		Thread.sleep(3000);
		return new CartPage(driver);
	}
}
