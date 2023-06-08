package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo5_MobileCommandScrollTest {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("appium:app", "C:\\Components\\khan-academy-7-3-2.apk");
		cap.setCapability("noReset", true);
		
		AndroidDriver driver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		if (driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).size() > 0) 
		{
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		}
		
		//Click on Search 
		//Click on Arts and humanities 
		
		
		//Click on Art of Asia
		
		//Click on The Himalayas

	}

}
