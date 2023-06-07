package com.brillio.androidcloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Demo2Test {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "9.0");
		cap.setCapability("deviceName", "Google Pixel 3");
		cap.setCapability("app", "bs://d2c5e5bb50109f3b459472754a2c4d2c398d15a6");

		HashMap<String, String> bstackDetails = new HashMap<String, String>();
		bstackDetails.put("projectName", "BrillioAppiumSessionProject");
		bstackDetails.put("buildName", "BrillioAppiumSessionBuild");
		bstackDetails.put("sessionName", "BrillioAppiumSession");
		bstackDetails.put("userName", "dinakaranbalaji1");
		bstackDetails.put("accessKey", "6yXRE4nK1fyvTHWA2kPD");

		cap.setCapability("bstack:options", bstackDetails);

		AppiumDriver driver = new AppiumDriver(new URL("http://hub.browserstack.com/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'address or')]"))
				.sendKeys("john@gmail.com");
		
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc='Password']"))
				.sendKeys("welcome123");

		driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='Sign in'])[2]")).click();

		String actualError = driver.findElement(AppiumBy.xpath("//*[contains(@text,'issue')]")).getText();
		System.out.println(actualError);

		String actualError1 = driver.findElement(AppiumBy.xpath("//*[contains(@text,'issue')]")).getAttribute("text");
		System.out.println(actualError1);

		// below code should run always otherwise it will terminate after 60s (which
		// will utitlise the free plan time)
		driver.quit();

	}

}
