package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Demo4NativeAppUiSelector {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("appium:app", "C:\\Components\\khan-academy-7-3-2.apk");
		
		AppiumDriver driver=new AppiumDriver(new URL("http://localhost:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Sign in\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"with email\")")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().description(\"First name\")")).sendKeys("john");
		
		//last name 
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().descriptionContains(\"Last\")")).sendKeys("john");
		
		//birthday - fill 18 Nov 1995
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Birthday\")")).click();

		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"android:id/numberpicker_input\").instance(0)")).click();
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"android:id/numberpicker_input\").instance(0)")).clear();
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"android:id/numberpicker_input\").instance(0)")).sendKeys("Dec");
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"android:id/numberpicker_input\").instance(1)")).click();
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"android:id/numberpicker_input\").instance(1)")).clear();
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"android:id/numberpicker_input\").instance(1)")).sendKeys("20");
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"android:id/numberpicker_input\").instance(2)")).click();
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"android:id/numberpicker_input\").instance(2)")).clear();
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().resourceId(\"android:id/numberpicker_input\").instance(2)")).sendKeys("1997");
		
		driver.findElement(AppiumBy.xpath("//*[@text='OK']")).click();
		
		driver.quit();
		
	}

}
