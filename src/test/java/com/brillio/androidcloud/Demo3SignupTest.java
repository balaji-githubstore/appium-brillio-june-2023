package com.brillio.androidcloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Demo3SignupTest {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "9.0");
		cap.setCapability("deviceName", "Google Pixel 3");
		cap.setCapability("app", "bs://d2c5e5bb50109f3b459472754a2c4d2c398d15a6");

		HashMap<String, String> bstackDetails = new HashMap<String, String>();
		
		bstackDetails.put("projectName", "BrillioAppiumSessionProject");
		bstackDetails.put("buildName", "BrillioAppiumSessionBuild2");
		bstackDetails.put("sessionName", "BrillioAppiumSession");
		
		bstackDetails.put("userName", "dinakaranbalaji1");
		bstackDetails.put("accessKey", "6yXRE4nK1fyvTHWA2kPD");

		cap.setCapability("bstack:options", bstackDetails);

		AppiumDriver driver = new AppiumDriver(new URL("http://hub.browserstack.com/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Settings']")).click();
		

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign up with email']")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign up with email']")).sendKeys("john");
		
		//enter lastname as wick
		//enter email wick@gmail.com
		//enter password as welcome123
		
		
		driver.quit();
	}

}
