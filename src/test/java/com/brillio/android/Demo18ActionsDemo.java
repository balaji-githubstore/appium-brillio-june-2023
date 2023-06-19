package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

/**
 * If nothing workout, then use Actions class to inject the text and handle by using click
 */
public class Demo18ActionsDemo {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
//		cap.setCapability("udid", "emulator-5554");
		
		//download and provide path for chromedriver based on the platform where appium server is running
		cap.setCapability("chromedriverExecutable", "/Users/balaji/Downloads/chromedriver_mac64/chromedriver");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.activateApp("com.docusign.ink");
		
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log In']")).click();
	
		Thread.sleep(5000);
		
		Actions actions=new Actions(driver);
		
		actions.sendKeys("hello@gmail.com").sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		actions.sendKeys("hello123").build().perform();
		
		
//		driver.pressKey(new KeyEvent().withKey(AndroidKey.A));
//		
//		driver.pressKey(new KeyEvent().withKey(AndroidKey.valueOf("hello")));
//		driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
		
		driver.quit();
	}

}
