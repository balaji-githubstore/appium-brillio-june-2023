package com.brillio.ioscloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
/**
 * Simulator
 */
public class Demo1NativeAppTest {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("deviceName", "iPhone 11 Pro");
		cap.setCapability("app", "bs://16194ec6f18bca2b17fcdc195767a9a098ddd056");

		HashMap<String, String> bstackDetails = new HashMap<String, String>();
		
		bstackDetails.put("projectName", "BrillioIosProject");
		bstackDetails.put("buildName", "BrillioIOSBuild");
		bstackDetails.put("sessionName", "BrillioIOSSession");
		
		bstackDetails.put("userName", "dinakaranbalaji1");
		bstackDetails.put("accessKey", "6yXRE4nK1fyvTHWA2kPD");

		cap.setCapability("bstack:options", bstackDetails);

		IOSDriver driver = new IOSDriver(new URL("http://hub.browserstack.com/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		System.out.println(driver.getPageSource());
		
		driver.quit();

	}

}
