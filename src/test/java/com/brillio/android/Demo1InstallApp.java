package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class Demo1InstallApp {

	public static void main(String[] args) throws MalformedURLException  {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "ASSSFFSF");
		//cap.setCapability("appium:app", "C:\\Components\\khan-academy-7-3-2.apk");
		
		AppiumDriver driver=new AppiumDriver(new URL("http://localhost:4723/wd/hub"),cap);
		
		System.out.println(driver.getPageSource());
		
		driver.quit();
		
		

	}

}
