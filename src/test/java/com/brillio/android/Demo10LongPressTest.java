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

public class Demo10LongPressTest {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		Point point=driver.findElement(AppiumBy.xpath("//*[@content-desc='Khan Academy']")).getLocation();
		
		System.out.println(point.x);
		System.out.println(point.y);

//		Dimension dim= driver.findElement(AppiumBy.xpath("//*[@text='Khan Academy']")).getSize();
//		System.out.println(dim.width);
//		System.out.println(dim.height);
		Thread.sleep(5000);
		Actions actions=new Actions(driver);
		
		PointerInput finger=new PointerInput(Kind.TOUCH, "finger");
		
		actions.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),point.x+30, point.y+30))
		.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
		.tick(new Pause(finger, Duration.ofMillis(10000)))
		.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
		.build().perform();
		
		driver.findElement(AppiumBy.xpath("//*[@text='App info']")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
