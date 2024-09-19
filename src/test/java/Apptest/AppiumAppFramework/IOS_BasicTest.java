package Apptest.AppiumAppFramework;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOS_BasicTest extends IOS_Base_Utility{

	@Test
	
	public void basicTest() {
		
		//Xpath, IOS, iosClassChain , IOSPredicateString , accessibility id, id
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		//IN IOS Xpath works Slower than iosClassChain....
		driver.findElement(AppiumBy.iOSClassChain("**/XCUITElementStaticText[`label=='Text Entry'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUITElementTypeCell")).sendKeys("Hello");
		driver.findElement(AppiumBy.accessibilityId("Ok")).click();
		
		//driver.findElement(AppiumBy.iOSNsPredicateString(" type=='XCUITElementStaticText' AND value== 'Conform/cancel'")).click();
		//OR cancel is changing everytime then we use
		driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUITElementStaticText' AND value BEGINSWITH[c] 'Conform'")).click();
		//OR we want ends with then we use like ..
		//driver.findElement(AppiumBy.iOSNsPredicateString(" type=='XCUITElementStaticText' AND value ENDSWITH[c] 'Cancel'")).click();
		
		driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText();

		driver.findElement(AppiumBy.iOSNsPredicateString("label =='Conform'")).click();
		
	}
}
