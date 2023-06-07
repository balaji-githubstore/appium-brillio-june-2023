package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Demo2NativeAppTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("appium:app", "C:\\Components\\khan-academy-7-3-2.apk");
		
		AppiumDriver driver=new AppiumDriver(new URL("http://localhost:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();
		
		//click on sign in again 
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();
		
		
		//enter username as john@gmail.com
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'address or')]")).sendKeys("john@gmail.com");
		//enter password as john123
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc='Password']")).sendKeys("welcome123");
		
		//click on sign in
		driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='Sign in'])[2]")).click();
		
		//get the error and print it
		String actualError=driver.findElement(AppiumBy.xpath("//*[contains(@text,'issue')]")).getText();
		System.out.println(actualError);
		
		String actualError1=driver.findElement(AppiumBy.xpath("//*[contains(@text,'issue')]")).getAttribute("text");
		System.out.println(actualError1);
		
		Thread.sleep(5000);
		
		driver.quit();
	
	}

}
