package Apptest.AppiumAppFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import junit.framework.Assert;

public class eCommerce_tc_1 extends Android_BaseTest{

	@BeforeTest
	public void preSetup() {

		Activity act=new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		//driver.startActivity(act);
		((JavascriptExecutor)driver).executeScript("mobile : startActivity",
				ImmutableMap.of("intent","u0 com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
		
	}
	@Test
	public void fillform_ErrorValidation() throws InterruptedException {
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Juned Saudagar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//To handle toast error messages use ..android.widget.Toast;
		String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		Thread.sleep(5000);

	}
	@Test
	public void fillform_PositiveTest() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Juned Saudagar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//To handle toast error messages use ..android.widget.Toast;
		String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		Thread.sleep(3000);

	}
}
