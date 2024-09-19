package Apptest.AppiumAppFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.PageObject.ios.HomePage;
import org.utils.AppiumUtils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOS_Base_Utility extends AppiumUtils {
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	public HomePage homePage;
	public void IOSTest() throws URISyntaxException, IOException {
		Properties prop=new Properties();
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\resources\\Data.properties");
		 prop.load(fis);
		 String ipAddress=prop.getProperty("ipAddress");
		 String port=prop.getProperty("port");
		service= startAppiumServer(ipAddress,Integer.parseInt(port));
		
		XCUITestOptions options=new XCUITestOptions();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\General-Store.apk");
		options.setPlatformVersion("");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		 driver =new IOSDriver(service.getUrl() , options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 HomePage homePage=new HomePage(driver);
	}

}
