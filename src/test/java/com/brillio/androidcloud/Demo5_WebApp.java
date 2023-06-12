package com.brillio.androidcloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Demo5_WebApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "9.0");
		cap.setCapability("deviceName", "Google Pixel 3");
		cap.setCapability("browserName", "chrome");

		HashMap<String, String> bstackDetails = new HashMap<String, String>();
		
		bstackDetails.put("projectName", "BrillioAppiumSessionProject");
		bstackDetails.put("buildName", "BrillioChromeAppiumSessionBuild2");
		bstackDetails.put("sessionName", "BrillioChromeAppiumSession");
		
		bstackDetails.put("userName", "dinakaranbalaji1");
		bstackDetails.put("accessKey", "6yXRE4nK1fyvTHWA2kPD");

		cap.setCapability("bstack:options", bstackDetails);

		AndroidDriver driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		driver.get("https://m.facebook.com/");
		System.out.println(driver.getTitle());
		driver.findElement(AppiumBy.xpath("//input[@name='email']")).sendKeys("hello everyone");

		
		driver.quit();

	}

}
