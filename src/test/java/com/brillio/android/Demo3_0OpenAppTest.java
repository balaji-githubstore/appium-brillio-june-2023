package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Demo3_0OpenAppTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("appPackage", "org.khanacademy.android");
		cap.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity");
		cap.setCapability("noReset", true);

		AppiumDriver driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// check visibility - it will not work here because Dismiss is not present
//		if(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).isDisplayed())
//		{
//			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
//		}

		//check presence of element
		if (driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).size() > 0) 
		{
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		}

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'address or')]"))
				.sendKeys("john@gmail.com");

		Thread.sleep(5000);

		driver.quit();
	}

}
