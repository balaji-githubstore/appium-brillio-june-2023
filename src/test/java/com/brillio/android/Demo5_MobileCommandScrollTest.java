package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo5_MobileCommandScrollTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("appium:app", "C:\\Components\\khan-academy-7-3-2.apk");
		cap.setCapability("noReset", true);

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		if (driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).size() > 0) 
		{
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		}

		// Click on Search
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Search']")).click();

		// Click on Arts and humanities
		driver.findElement(AppiumBy.xpath("//*[@text='Arts and humanities']")).click();

		// Scroll using mobile command

		HashMap<String, String> map1 = new HashMap<>();
		map1.put("strategy", "-android uiautomator");
		map1.put("selector", "UiSelector().text(\"Art of Asia\")");

		driver.executeScript("mobile: scroll", map1);

		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Art of Asia\")")).click();

		// Click on The Himalayas
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("strategy", "-android uiautomator");
		map2.put("selector", "UiSelector().textContains(\"Himalay\")");

		driver.executeScript("mobile: scroll", map2);

		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"Himalay\")")).click();
		
		
		//scroll and click on Prayer wheel
		HashMap<String, String> map3 = new HashMap<>();
		map3.put("strategy", "-android uiautomator");
		map3.put("selector", "UiSelector().textContains(\"wheel\")");

		driver.executeScript("mobile: scroll", map3);

		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Prayer wheel\")")).click();

		Thread.sleep(5000);

		driver.quit();
	}

}
