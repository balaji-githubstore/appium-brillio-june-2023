package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo16HybridApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("udid", "emulator-5554");
		
		//download and provide path for chromedriver based on the platform where appium server is running
		cap.setCapability("chromedriverExecutable", "/Users/balaji/Downloads/chromedriver_mac64/chromedriver");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//android native app - uiautomator2driver - for handling xml (app source)
//web app - chromedriver,safaridriver - for handling html (page source) 
		
		driver.activateApp("com.docusign.ink");
		
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log In']")).click();
		Thread.sleep(5000);
		//gives all the view present in the current screen 
		System.out.println(driver.getContextHandles());
		
		//setting the context to webview
		driver.context("WEBVIEW_chrome");
		
		driver.findElement(By.xpath("//*[@placeholder='Enter email']")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//*[@data-qa='submit-username']")).click();
		
		driver.findElement(By.xpath("//*[@placeholder='Enter password']")).sendKeys("john211");
		
		//click on login 
		
		
		//switching back to native view after successful login 
		driver.context("NATIVE_APP");
		driver.quit();
		
	}

}
