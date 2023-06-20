package com.brillio.ios.real;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
/**
 * Real device scroll using mobile command and logics
 */
public class Demo3NativeAppMobileCommandScroll {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("deviceName", "iPad");
		cap.setCapability("platformVersion", "16.5");
		cap.setCapability("udid", "417da800b3114ff6776f5c37c65974d071364376");
		
		IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.activateApp("org.khanacademy.Khan-Academy");
		
		//XCUIElementTypeButton[@name='Explore']
		//XCUIElementTypeOther[@name='Math']//XCUIElementTypeButton[@name='Math']
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Explore']")).click();
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='Math']//XCUIElementTypeButton[@name='Math']")).click();
		
		//XCUIElementTypeButton[@name='Integrated math 3']
		
		System.out.println(driver.findElements(AppiumBy.xpath("//XCUIElementTypeButton[@name='Integrated math 3']")).size());
		System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Integrated math 3']")).isDisplayed());
		
		
		while(driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Integrated math 3']")).isDisplayed()==false)		
		{
			//scroll
			Map<String, String> map1 = new HashMap<String, String>();
			map1.put("direction", "down");
			driver.executeScript("mobile: scroll", map1);
		}
		System.out.println(driver.findElements(AppiumBy.xpath("//XCUIElementTypeButton[@name='Integrated math 3']")).size());
		System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Integrated math 3']")).isDisplayed());
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Integrated math 3']")).click();
		driver.quit();
	}

}
