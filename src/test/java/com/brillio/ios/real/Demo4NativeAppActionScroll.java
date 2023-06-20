package com.brillio.ios.real;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
/**
 * Real device scroll using Actions class logics
 */
public class Demo4NativeAppActionScroll {

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
		
		Dimension dim = driver.manage().window().getSize();

		int x1 = (int) (dim.width * (90 / 100.0));
		int y1 = (int) (dim.height * (75 / 100.0));

		int x2 = (int) (dim.width * (90 / 100.0));
		int y2 = (int) (dim.height * (25 / 100.0));

		Actions actions = new Actions(driver);

		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		
		while(driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Integrated math 3']")).isDisplayed()==false)		
		{
			//scroll
			actions.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x1, y1))
			.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
			.tick(new Pause(finger, Duration.ofMillis(600)))
			.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x2, y2))
			.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())).build().perform();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(driver.findElements(AppiumBy.xpath("//XCUIElementTypeButton[@name='Integrated math 3']")).size());
		System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Integrated math 3']")).isDisplayed());
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Integrated math 3']")).click();
		driver.quit();
	}

}
