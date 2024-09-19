package Apptest.AppiumAppFramework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.PageObject.android.CartPage;
import org.PageObject.android.FormPage;
import org.PageObject.android.ProductCatalogue;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ECommerece_TC_A2 extends Android_BaseTest{

	@Test(dataProvider="getData")
	public void fillFormTest(String name, String gender, String country) throws InterruptedException {
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountrySelection(country);
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
	@BeforeTest
	//for parameterizing data we need to set the screen 1st. then login page will be displayed for next data.
	//so we create setActivity method in "FormPage.java"; otherwise it will not work..
	//so that it will test multiple data 
	public void preSetup() {
		formPage.setActivity();
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>> data=getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\Apptest\\AppiumAppFramework\\testData\\Ecommerce.json");
//		return new Object[][] {{"Juned","female","Argentina"},
//			                   {"Sonu","male","California"},
//			                   {"Sandy","female","Afganistan"}
	//		};
		return new Object[][] {  {data.get(0)}, {data.get(1)}};
	}
}
