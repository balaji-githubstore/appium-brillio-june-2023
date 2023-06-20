package com.brillio.ios.real;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class Demo1OpenApp {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("deviceName", "iPad");
		cap.setCapability("platformVersion", "16.5");
		cap.setCapability("udid", "417da800b3114ff6776f5c37c65974d071364376");
		
		//to open app - get the bundleId from development team
		//cap.setCapability("bundleId", "org.khanacademy.Khan-Academy");


		IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.activateApp("org.khanacademy.Khan-Academy");
		
		System.out.println(driver.getPageSource());
		
		//khanacademy
		//https://apps.apple.com/us/app/khan-academy/id469863705
		
		//clock
		//https://apps.apple.com/us/app/clock/id1584215688
		
		//https://itunes.apple.com/lookup?id=1584215688
		
		driver.quit();

	}

}
