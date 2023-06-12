package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
/**
 * Working on mobile android web apps
 * @author JiDi
 *
 */
public class Demo14WebApp2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("chromedriverExecutable", "C:\\Components\\chromedriver_win32\\chromedriver.exe");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://m.facebook.com/");
		System.out.println(driver.getTitle());
		driver.findElement(AppiumBy.xpath("//input[@name='email']")).sendKeys("hello everyone");
		
		
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
