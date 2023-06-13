package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
/**
 * Scroll using Actions class - Latest steps to scroll using Appium
 * @author Balaji Dinakaran
 *
 */
public class Demo7_ActionsScrollTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("appium:app", "C:\\Components\\khan-academy-7-3-2.apk");
		cap.setCapability("noReset", true);

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		if (driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).size() > 0) 
		{
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		}

		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Search']")).click();

		driver.findElement(AppiumBy.xpath("//*[@text='Arts and humanities']")).click();
		
		
		//below code is not recommended as it is depreciated
		
//		(new TouchAction(driver))
//		  .press(PointOption.point(839, 1157))
//		  .waitAction(WaitOptions.waitOptions(Duration.ofMillis(600))))
//		  .moveTo(PointOption.point(877, 751))
//		  .release()
//		  .perform();

		
		//New code for scroll, tap, long press using Actions class
		Actions actions=new Actions(driver);
		
		PointerInput finger=new PointerInput(Kind.TOUCH, "finger");
		
		//scroll until Art of Asia is present
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		while(driver.findElements(AppiumBy.xpath("//*[@text='Art of Asia']")).size()==0)
		{
			actions.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),686, 958))
			.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
			.tick(new Pause(finger, Duration.ofMillis(600)))
			.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),684, 456))
			.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
			.build().perform();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(AppiumBy.xpath("//*[@text='Art of Asia']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		while(driver.findElements(AppiumBy.xpath("//*[contains(@text,'The Hima')]")).size()==0)
		{
			actions.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),686, 958))
			.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
			.tick(new Pause(finger, Duration.ofMillis(600)))
			.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),684, 456))
			.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
			.build().perform();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(AppiumBy.xpath("//*[contains(@text,'The Hima')]")).click();
		
		
		
		Thread.sleep(5000);
		
		driver.quit();
		

	}

}
