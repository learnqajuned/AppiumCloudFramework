package org.utils;
// Common Methods which are Reusable in Android and IOS for those we create CommonUtils...

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {

	public AppiumDriverLocalService service;

	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(port).build(); 
		//.withTimeout(Duration.ofSeconds(300))
		service.start();
		return service;
	}
	public Double getformattedAmount(String amount) {
		Double price=Double.parseDouble(amount.substring(1));
		return price;
	}

	public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException{
		//Concert JsonFile content To JsonString.....
		//System.getProperty("user.dir")+"C:\\Users\\user\\eclipse-workspace\\AppiumAppFramework\\src\\test\\java\\Apptest\\AppiumAppFramework\\testData\\Ecommerce.json"
		String jsonContent=FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);

		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, 
				new TypeReference<List<HashMap<String,String>>>(){

		});
		return data;
	}

	public void waitForElementToAppear(WebElement ele,AppiumDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains((ele),"text", "Cart"));
	}
	public String getScreenshotPath(String testCaseName,AppiumDriver driver) throws IOException {
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		String filepath=System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileUtils.copyFile(source,new File (filepath));
		return filepath;
	}
}
