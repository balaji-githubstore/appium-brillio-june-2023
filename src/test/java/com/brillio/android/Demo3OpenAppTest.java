package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Demo3OpenAppTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("appPackage", "org.khanacademy.android");
		cap.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity");
		cap.setCapability("noReset", true);
		
		AppiumDriver driver=new AppiumDriver(new URL("http://localhost:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		//click on settings
		// click on sign in 
		//click on sign up with email 
		//fill firstname, lastname, dob - Dec 20, 2000,  password, create 
		
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
