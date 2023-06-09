package com.brillio.androidcloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Demo7_ActionsScrollTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
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

		AndroidDriver driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		if (driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).size() > 0) 
		{
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		}

		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Search']")).click();

		driver.findElement(AppiumBy.xpath("//*[@text='Arts and humanities']")).click();
		
		Actions actions=new Actions(driver);
		
		PointerInput finger=new PointerInput(Kind.TOUCH, "finger");
		
		//scroll until Art of Asia is present 
		
		actions.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),839, 1157))
		.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
		.tick(new Pause(finger, Duration.ofMillis(600)))
		.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),877, 751))
		.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
		.build().perform();
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
