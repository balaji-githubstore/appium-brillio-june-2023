package com.brillio.ios;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class Demo4MobileCommandsScroll {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("deviceName", "iPhone 14 Pro Max");
		cap.setCapability("platformVersion", "16.4");
//		cap.setCapability("automationName", "XCUITestDriver");
		
		//to open app - get the bundleId from development team
		cap.setCapability("bundleId", "com.apple.Health");


		IOSDriver driver = new IOSDriver(new URL("http://localhost:7989/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		System.out.println(driver.getPageSource());
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Edit']"));
		
		
		//element id for using in mobile commands
		RemoteWebElement ele1=(RemoteWebElement) driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Edit']"));
		System.out.println(ele1.getId());
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Edit']")).click();
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='All']")).click();
		
		
		//target element should not be present
		HashMap<String, String> map1=new  HashMap<String, String>();
		map1.put("direction", "down");
		map1.put("predicateString", "name=='Selenium'");
		
		driver.executeScript("mobile: scroll", map1);
		
		
//		HashMap<String, String> map1=new  HashMap<String, String>();
//		map1.put("direction", "down");
//		map1.put("name", "selenium");
//		
//		driver.executeScript("mobile: scroll", map1);
		
		//XCUIElementTypeButton[@name='Done']
		driver.quit();
 	}

}
