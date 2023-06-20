package com.brillio.ios.real;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
/**
 * Real device scroll using mobile command with predicateString
 */
public class Demo7NativeAppPickerWheel {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("deviceName", "iPad");
		cap.setCapability("platformVersion", "16.5");
		cap.setCapability("udid", "417da800b3114ff6776f5c37c65974d071364376");
		
		IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.activateApp("com.apple.mobiletimer");
		
		int set=16;
		//get current hours
		String value=driver.findElement(AppiumBy.xpath("(//XCUIElementTypePickerWheel)[1]")).getAttribute("value");
		System.out.println(value);
		
		driver.findElement(AppiumBy.xpath("(//XCUIElementTypePickerWheel)[1]")).sendKeys("16 hours");
		
		driver.findElement(AppiumBy.xpath("(//XCUIElementTypePickerWheel)[2]")).sendKeys("20 min");
		
		driver.findElement(AppiumBy.xpath("(//XCUIElementTypePickerWheel)[3]")).sendKeys("30 sec");
		
		
		
		
		driver.quit();
	}

}
