package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo11LongPressTest2 {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("appPackage", "sk.styk.martin.apkanalyzer");
		cap.setCapability("appActivity", "sk.styk.martin.apkanalyzer.ui.main.MainActivity");
		cap.setCapability("noReset", true);
		

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(AppiumBy.xpath("//*[@text='Analytics']")).click();
		
		Point point=driver.findElement(AppiumBy.xpath("//*[@text='Package name']")).getLocation();
		
		System.out.println(point.x);
		System.out.println(point.y);

//		Dimension dim= driver.findElement(AppiumBy.xpath("//*[@text='Khan Academy']")).getSize();
//		System.out.println(dim.width);
//		System.out.println(dim.height);
		Thread.sleep(5000);
		Actions actions=new Actions(driver);
		
		PointerInput finger=new PointerInput(Kind.TOUCH, "finger");
		
		actions.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),point.x+10, point.y+10))
		.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
		.tick(new Pause(finger, Duration.ofMillis(10000)))
		.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
		.build().perform();
		
		//driver.findElement(AppiumBy.xpath("//*[@text='App info']")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
