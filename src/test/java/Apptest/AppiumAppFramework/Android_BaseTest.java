package Apptest.AppiumAppFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.PageObject.android.FormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.utils.AppiumUtils;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Android_BaseTest extends AppiumUtils{

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws URISyntaxException, IOException {
		
		//Code To Start Server
				 Properties prop=new Properties();
				 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\resources\\Data.properties");
				 prop.load(fis);
				 String ipAddress=prop.getProperty("ipAddress");
				 String port=prop.getProperty("port");
				service= startAppiumServer(ipAddress,Integer.parseInt(port));
				
				UiAutomator2Options options=new UiAutomator2Options();
				options.setDeviceName(prop.getProperty("AndroidDeviceName"));
				//options.setChromedriverExecutable("C:\\Users\\user\\Downloads\\chrome-win64\\chrome-win64");
				//options.setApp("C:\\Users\\user\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
				options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\General-Store.apk");

				//AndroidDriver , IOSDriver
				 driver=new AndroidDriver(service.getUrl(),options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				FormPage formPage=new FormPage(driver);
	}
	public void LongPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration", 2000));
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
	
	public void ScrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	
	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	public Double getformattedAmount(String amount) {
		Double price=Double.parseDouble(amount.substring(1));
		return price;
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown(){
		driver.quit();
		service.stop();
	}
}
