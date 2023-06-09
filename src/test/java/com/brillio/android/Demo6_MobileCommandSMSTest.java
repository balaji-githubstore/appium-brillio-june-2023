package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
/**
 * Read SMS, Battery info, notification using Mobile Command UiAutomator2 driver
 * @author Balaji Dinakaran
 *
 */
public class Demo6_MobileCommandSMSTest {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("udid", "emulator-5554");


		AppiumDriver driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		HashMap<String, Integer> map=new HashMap<>();
		map.put("max", 3);
		
		String result=driver.executeScript("mobile: listSms", map).toString();
		
		System.out.println(result);
		
		result=driver.executeScript("mobile: batteryInfo").toString();
		
		System.out.println(result);
		
		driver.quit();

	}

}
