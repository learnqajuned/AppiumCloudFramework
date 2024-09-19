package Apptest.AppiumAppFramework;

import org.PageObject.android.CartPage;
import org.PageObject.android.FormPage;
import org.PageObject.android.ProductCatalogue;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ECommerece_TC extends Android_BaseTest{

	@Test
	public void fillFormTest() throws InterruptedException {
		FormPage formPage=new FormPage(driver);
		formPage.setNameField("Juned");
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		ProductCatalogue productCatalogue=formPage.submitForm();
		productCatalogue.addToCartByIndex(0);
		productCatalogue.addToCartByIndex(0);
		CartPage cartpage=productCatalogue.goToCart();
		
		double totalsum=cartpage.getProductSum();
		double displayFormattedSum=cartpage.getTotalAmountDisplayed();
		Assert.assertEquals(totalsum, displayFormattedSum);
		
		cartpage.acceptTermsConditions();
		cartpage.submitOrder();
		
	}
	@BeforeTest(alwaysRun=true)
	//for parameterizing data we need to set the screen 1st. then login page will be displayed for next data.
	//so we create setActivity method in "FormPage.java"; otherwise it will not work..
	//so that it will test multiple data 
	public void preSetup() {
		formPage.setActivity();
	}
}