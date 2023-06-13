package com.brillio.ioscloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
/**
 * 
 * Scroll on ios app using Actions to make the element visible 
 * @author Balaji Dinakaran
 *
 */
public class Demo2NativeAppTestScroll {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("deviceName", "iPhone 11 Pro");
		cap.setCapability("app", "bs://16194ec6f18bca2b17fcdc195767a9a098ddd056");

		HashMap<String, String> bstackDetails = new HashMap<String, String>();
		
		bstackDetails.put("projectName", "BrillioIosProject");
		bstackDetails.put("buildName", "BrillioIOSBuild");
		bstackDetails.put("sessionName", "BrillioIOSSession");
		
		bstackDetails.put("userName", "dinakaranbalaji1");
		bstackDetails.put("accessKey", "6yXRE4nK1fyvTHWA2kPD");

		cap.setCapability("bstack:options", bstackDetails);

		IOSDriver driver = new IOSDriver(new URL("http://hub.browserstack.com/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
//		System.out.println(driver.getPageSource());
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name='test-Username']")).sendKeys("standard_user");
		driver.findElement(AppiumBy.xpath("//*[@name='test-Password']")).sendKeys("secret_sauce");
		
		//click on login
		
		//using name method
		//driver.findElement(AppiumBy.name("test-LOGIN")).click();
		
		//using accessibility id method
		//driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
		
		//using xpath method
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-LOGIN']")).click();
		
		//click on add to cart item 1
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-ADD TO CART']")).click();
		//click on add to cart item 2
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-ADD TO CART']")).click();
		//click on add to cart item 3
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-ADD TO CART']")).click();
		
		//go to cart
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-Cart']")).click();
		
		
		//click on checkout
		driver.findElement(AppiumBy.xpath("//*[@name='test-CHECKOUT']")).click();
		
		
		//enter firstname as john 
		driver.findElement(AppiumBy.name("test-First Name")).sendKeys("Balaji");
		
		//enter lastname as wick
		driver.findElement(AppiumBy.xpath("//*[@name='test-Last Name' and @value='Last Name']")).sendKeys("Balaji");
		
		//enter zip code as 5000223
		driver.findElement(AppiumBy.name("test-Zip/Postal Code")).sendKeys("44354");
		
		//you can hide keyboard only if shown otherwise it will throw error
		if(driver.isKeyboardShown())
		{
//			driver.hideKeyboard();
			driver.findElement(AppiumBy.iOSNsPredicateString("name=='Return'")).click();
		}
		
		driver.findElement(AppiumBy.iOSNsPredicateString("name=='test-CONTINUE'")).click();
		
		
		//element is present if count>0
		System.out.println(driver.findElements(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'Card')]")).size());
		
		//element is visible if true
		System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'Card')]")).isDisplayed());
		
		//scroll until element visible logic
		
		Dimension dim = driver.manage().window().getSize();
		int x1 = (int) (dim.width * (90 / 100.0));
		int y1 = (int) (dim.height * (75 / 100.0));
		int x2 = (int) (dim.width * (90 / 100.0));
		int y2 = (int) (dim.height * (25 / 100.0));

		Actions actions = new Actions(driver);

		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		//scroll logic based on element visiblity
		while (driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'Card')]")).isDisplayed()==false) {
			actions.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x1, y1))
					.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
					.tick(new Pause(finger, Duration.ofMillis(600)))
					.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x2, y2))
					.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())).build().perform();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		
		
		//get the payment information detail and print 
		String actualValue=driver.findElement
				(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'Card')]")).getAttribute("name");
		
		System.out.println(actualValue);
		
		actualValue=driver.findElement
				(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'Card')]")).getAttribute("value");
		
		System.out.println(actualValue);
		driver.quit();

	}

}
