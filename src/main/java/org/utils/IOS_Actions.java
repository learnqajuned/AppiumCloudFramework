package org.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOS_Actions extends AppiumUtils{
	IOSDriver driver;
   public IOS_Actions(IOSDriver driver) {
	   
		this.driver=driver;
	}

	public void LongPressAction(WebElement ele) {
		Map<String, Object> param=new HashMap<>();
		param.put("element", ((RemoteWebElement)ele).getId());
		param.put("duration", 5);
		
		driver.executeScript("mobile:touchAndHold", param );
	}
	public void ScrollToEndAction() {
		boolean canScrollMore;
		//No prior idea where to scroll..
		do {
	   canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
		}while(canScrollMore);
	}
	
	public void ScrollToWebElement(WebElement ele) {
		Map<String , Object> map=new HashMap<>();
		map.put("direction","down");
		map.put("element", ((RemoteWebElement)ele).getId());
		
		driver.executeScript("mobile:scroll", map);	}
	
	public void swipeAction(WebElement ele, String direction) {
		Map<String, String> m=new HashMap<>();
		m.put("bundleId", "com.apple.mobileslideshow");
		driver.executeScript("mobile:launchApp", m);
	}
	
}
