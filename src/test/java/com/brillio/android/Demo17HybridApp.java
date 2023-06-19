package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * Logic to find the element's exact view 
 */
public class Demo17HybridApp {

	public static void main(String[] args) throws MalformedURLException {
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
	
		System.out.println("Current Context Detail ");
		System.out.println(driver.getContext());
		
		System.out.println("All Context Detail ");
		System.out.println(driver.getContextHandles());
		
		//will switch the context and check for given xpath & stays on that view
		for(String appContext : driver.getContextHandles())
		{
			System.out.println(appContext);
			driver.context(appContext);
			if(driver.findElements(AppiumBy.xpath("//*[@placeholder='Enter email']")).size()>0)
			{
				break;
			}
		}
		
		
		System.out.println("Current Context Detail ");
		System.out.println(driver.getContext());
		
		driver.findElement(By.xpath("//*[@placeholder='Enter email']")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//*[@data-qa='submit-username']")).click();
		
		driver.findElement(By.xpath("//*[@placeholder='Enter password']")).sendKeys("john211");
		
		driver.quit();
	}

}
