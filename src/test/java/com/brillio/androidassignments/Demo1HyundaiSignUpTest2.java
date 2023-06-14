package com.brillio.androidassignments;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo1HyundaiSignUpTest2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		//work only on real or virtual device
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.installApp("C:\\Components\\com.bsl.hyundai_2021-08-09.apk");
//		driver.installApp("C:\\Components\\com.bsl.hyundai_2021-08-09.apk");
//		driver.installApp("C:\\Components\\com.bsl.hyundai_2021-08-09.apk");
		
		driver.activateApp("com.bsl.hyundai");
		
		System.out.println(driver.getPageSource());
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='DENY']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='DENY']")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'SIGN UP')]")).click();
		
		
		driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@resource-id='com.bsl.hyundai:id/edtFullname']")).sendKeys("john");
		
		driver.findElement(AppiumBy.id("com.bsl.hyundai:id/edtMobileNumber")).sendKeys("999898");
		
//		5.	Enter name, mobile number, email id, password, confirm password 
//		6.	Click on check box  
//		7.	No need to click on register 

		driver.quit();
	}

}
