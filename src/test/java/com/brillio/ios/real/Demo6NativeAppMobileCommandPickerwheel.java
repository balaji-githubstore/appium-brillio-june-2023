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
public class Demo6NativeAppMobileCommandPickerwheel {

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
		
		int hours= Integer.valueOf(value.replace(" hours", ""));
		
		
		System.out.println(hours);
		
		//16 hours   20 mins     30 sec 
		
		while(hours<set)
		{
			RemoteWebElement ele= (RemoteWebElement) driver.findElement(AppiumBy.xpath("(//XCUIElementTypePickerWheel)[1]"));
			
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("elementId", ele.getId());
			map1.put("order", "next");
			map1.put("offset", 0.15);
			driver.executeScript("mobile: selectPickerWheelValue", map1);
			
			value=driver.findElement(AppiumBy.xpath("(//XCUIElementTypePickerWheel)[1]")).getAttribute("value");
			System.out.println(value);
			
			hours= Integer.valueOf(value.replace(" hours", ""));
			
		}
		
		while(hours>set)
		{
			RemoteWebElement ele= (RemoteWebElement) driver.findElement(AppiumBy.xpath("(//XCUIElementTypePickerWheel)[1]"));
			
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("elementId", ele.getId());
			map1.put("order", "previous");
			map1.put("offset", 0.15);
			driver.executeScript("mobile: selectPickerWheelValue", map1);
			
			value=driver.findElement(AppiumBy.xpath("(//XCUIElementTypePickerWheel)[1]")).getAttribute("value");
			System.out.println(value);
			
			hours= Integer.valueOf(value.replace(" hours", ""));
			
		}
		
		
		
		
		driver.quit();
	}

}
