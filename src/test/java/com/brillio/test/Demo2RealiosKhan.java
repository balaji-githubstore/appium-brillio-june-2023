package com.brillio.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Demo2RealiosKhan {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("appium:deviceName", "iPad");
		cap.setCapability("appium:platformVersion", "16.5");
		cap.setCapability("udid", "417da800b3114ff6776f5c37c65974d071364376");
		cap.setCapability("automationName", "XCUITest");
		IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.activateApp("org.khanacademy.Khan-Academy");
		
		driver.findElement(AppiumBy.name("Search")).click();
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='Math']/XCUIElementTypeButton[@name='Math']")).click();
		
		
		
		List<WebElement> elements= driver.findElements(AppiumBy.xpath("//XCUIElementTypeButton"));
		
		for(WebElement ele:elements)
		{
			System.out.println(ele.getAttribute("name"));
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		
		System.out.println(driver.findElements(AppiumBy.xpath("//XCUIElementTypeButton[contains(@name,'Get ready for Precalculus')]")).size());
		System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[contains(@name,'Get ready for Precalculus')]")).isDisplayed());
		
		while(driver.findElements(AppiumBy.xpath("//XCUIElementTypeButton[contains(@name,'Get ready for Precalculus')]")).size()==1 
				&& !driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[contains(@name,'Get ready for Precalculus')]")).isDisplayed())
				
		{
			System.out.println(driver.findElements(AppiumBy.xpath("//XCUIElementTypeButton[contains(@name,'Get ready for Precalculus')]"))
					.size());
			driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[contains(@name,'Get ready for Precalculus')]")).click();
		
		System.out.println("done");
//		driver.quit();
	}

}
