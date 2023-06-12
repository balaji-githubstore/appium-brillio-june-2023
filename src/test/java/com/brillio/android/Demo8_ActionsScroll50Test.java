package com.brillio.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Demo8_ActionsScroll50Test {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("udid", "emulator-5559");
//		cap.setCapability("appium:app", "C:\\Components\\khan-academy-7-3-2.apk");
//		cap.setCapability("noReset", true);

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Dimension dim = driver.manage().window().getSize();

		System.out.println(dim.width);
		System.out.println(dim.height);
		
		int x1=(int) (dim.width*(90/100.0));
		int y1=(int) (dim.height*(75/100.0));
		
		int x2=(int) (dim.width*(90/100.0));
		int y2=(int) (dim.height*(25/100.0));
		
		System.out.println(x1);

		System.out.println(y1);

		System.out.println(x2);

		System.out.println(y2);

		Thread.sleep(5000);

		driver.quit();

	}
}
