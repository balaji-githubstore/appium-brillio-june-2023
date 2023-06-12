package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Demo12TapTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("appPackage", "org.khanacademy.android");
		cap.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity");
		cap.setCapability("noReset", true);

		AppiumDriver driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// check presence of element
		if (driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).size() > 0) {
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		}

		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Settings']"))
				.click();

		Point point = driver.findElement(AppiumBy.xpath("//*[@text='OFF']")).getLocation();

		System.out.println(point.x);
		System.out.println(point.y);
		
		Actions actions = new Actions(driver);

		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
		
		for (int i = 1; i <= 10; i++) {

			actions.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), point.x + 10,
					point.y + 10)).tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
					.tick(new Pause(finger, Duration.ofMillis(600)))
					.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())).build().perform();
		}

		Thread.sleep(5000);

		driver.quit();
	}

}
