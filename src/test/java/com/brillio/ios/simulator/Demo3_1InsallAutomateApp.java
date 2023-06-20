package com.brillio.ios.simulator;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Demo3_1InsallAutomateApp {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("deviceName", "iPhone 14 Pro Max");
		cap.setCapability("platformVersion", "16.4");

		//for simulator - need to use .app file
		//for real device - need to ask for .ipa file
		
		cap.setCapability("app", "/Users/balaji/Documents/Component/saucelab_app.app");


		IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		System.out.println(driver.getPageSource());
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name='test-Username']")).sendKeys("standard_user");
		driver.findElement(AppiumBy.xpath("//*[@name='test-Password']")).sendKeys("secret_sauce");
		
		//click on login
		
		//using name method
		//driver.findElement(AppiumBy.name("test-LOGIN")).click();
		
		//using accessibility id method
		//driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
		
		//using xpath method
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-LOGIN']")).click();
		
		//click on add to cart item 1
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-ADD TO CART']")).click();
		//click on add to cart item 2
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-ADD TO CART']")).click();
		//click on add to cart item 3
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-ADD TO CART']")).click();
		
		//go to cart
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-Cart']")).click();
		
		
		//click on checkout
		driver.findElement(AppiumBy.xpath("//*[@name='test-CHECKOUT']")).click();
		
		
		//enter firstname as john 
		driver.findElement(AppiumBy.name("test-First Name")).sendKeys("Balaji");
		
		//enter lastname as wick
		driver.findElement(AppiumBy.xpath("//*[@name='test-Last Name' and @value='Last Name']")).sendKeys("Balaji");
		
		//enter zip code as 5000223
		driver.findElement(AppiumBy.name("test-Zip/Postal Code")).sendKeys("44354");
		
		//you can hide keyboard only if shown otherwise it will throw error
		if(driver.isKeyboardShown())
		{
//			driver.hideKeyboard();
			driver.findElement(AppiumBy.iOSNsPredicateString("name=='Return'")).click();
		}
		
		driver.findElement(AppiumBy.iOSNsPredicateString("name=='test-CONTINUE'")).click();
		
		
		//element is present if count>0
		System.out.println(driver.findElements(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'Card')]")).size());
		
		//element is visible if true
		System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'Card')]")).isDisplayed());
		
		//get the payment information detail and print 
		String actualValue=driver.findElement
				(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'Card')]")).getAttribute("name");
		
		System.out.println(actualValue);
		
		actualValue=driver.findElement
				(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'Card')]")).getAttribute("value");
		
		System.out.println(actualValue);
		driver.quit();
		
	
	}

}
