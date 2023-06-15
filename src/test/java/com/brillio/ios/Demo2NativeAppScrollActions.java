package com.brillio.ios;

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

public class Demo2NativeAppScrollActions {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("deviceName", "iPhone 14 Pro Max");
		cap.setCapability("platformVersion", "16.4");
//		cap.setCapability("automationName", "XCUITestDriver");
		
		//to open app - get the bundleId from development team
		cap.setCapability("bundleId", "com.apple.Health");


		IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		System.out.println(driver.getPageSource());
		
		
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Edit']")).click();
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='All']")).click();
		
		
		Dimension dim = driver.manage().window().getSize();

		int x1 = (int) (dim.width * (90 / 100.0));
		int y1 = (int) (dim.height * (75 / 100.0));

		int x2 = (int) (dim.width * (90 / 100.0));
		int y2 = (int) (dim.height * (25 / 100.0));

		Actions actions = new Actions(driver);

		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		while (driver.findElements(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Selenium']")).size() == 0) {
			actions.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x1, y1))
					.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
					.tick(new Pause(finger, Duration.ofMillis(600)))
					.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x2, y2))
					.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())).build().perform();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Selenium']")).click();
		
		//XCUIElementTypeButton[@name='Done']
		driver.quit();
	}

}
