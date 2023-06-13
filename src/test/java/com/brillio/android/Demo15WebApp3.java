package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
public class Demo15WebApp3 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		
//		option.addArguments("--disable-notifications");
//		option.addArguments("start-maximized");
		ChromeOptions option=new ChromeOptions();
		
		HashMap<String, String> map=new HashMap<>();
		map.put("deviceName", "Pixel 5");
		
		option.setExperimentalOption("mobileEmulation",map);
		
		
		WebDriver driver=new ChromeDriver(option);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//		driver.get("https://www.irctc.co.in/nget/train-search");
//		System.out.println(driver.getTitle());
//		driver.findElement(AppiumBy.xpath("//input[@name='email']")).sendKeys("hello everyone");
		
		driver.get("https://m.facebook.com/");
		System.out.println(driver.getTitle());
		driver.findElement(AppiumBy.xpath("//input[@name='email']")).sendKeys("hello everyone");
		//enter password as test123
		//Click on login
	
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
