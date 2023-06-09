package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
/**
 * Scroll using Actions class exactly 50% - Latest steps to scroll using Appium
 * @author Balaji Dinakaran
 *
 */
public class Demo9_ActionsScroll50Test2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("appium:app", "C:\\Components\\khan-academy-7-3-2.apk");
		cap.setCapability("noReset", true);

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		if (driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).size() > 0) {
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		}

		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Search']")).click();

		driver.findElement(AppiumBy.xpath("//*[@text='Math']")).click();

		Dimension dim = driver.manage().window().getSize();

		int x1 = (int) (dim.width * (90 / 100.0));
		int y1 = (int) (dim.height * (75 / 100.0));

		int x2 = (int) (dim.width * (90 / 100.0));
		int y2 = (int) (dim.height * (25 / 100.0));

		Actions actions = new Actions(driver);

		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		while (driver.findElements(AppiumBy.xpath("//*[@text='Early math review']")).size() == 0) {
			actions.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x1, y1))
					.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
					.tick(new Pause(finger, Duration.ofMillis(600)))
					.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x2, y2))
					.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())).build().perform();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(AppiumBy.xpath("//*[@text='Early math review']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		while (driver.findElements(AppiumBy.xpath("//*[@text='Geometry']")).size() == 0) {
			actions.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x1, y1))
					.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
					.tick(new Pause(finger, Duration.ofMillis(600)))
					.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x2, y2))
					.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())).build().perform();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(AppiumBy.xpath("//*[@text='Geometry']")).click();
		
		
		driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout/android.widget.Button[@content-desc='Add Bookmark']")).click();

		driver.findElement(AppiumBy.xpath("//*[@content-desc='Bookmarks tab']")).click();
		
//		String actualValue=driver.findElement(AppiumBy.xpath("//*[@text='Early math review']/..")).getText();
		
//		System.out.println(actualValue);
		
		
		//Below code extract all text in bookmark page present for tagname //android.widget.TextView 
		
		List<WebElement> elements= driver.findElements(AppiumBy.xpath("//android.widget.TextView"));
		
		System.out.println(elements.size());
		
//		System.out.println(elements.get(0).getText());
//		System.out.println(elements.get(1).getText());
//		System.out.println(elements.get(2).getText());
		
		for(int i=0;i<elements.size();i++)
		{
			System.out.println(elements.get(i).getText());
		}
		
		
		//advance for loop
		for(WebElement ele : elements)
		{
			System.out.println(ele.getText());
		}
		
		
		Thread.sleep(5000);

		driver.quit();

	}
}
