package com.brillio.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo1Hybrid {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("appium:deviceName", "mydevice-redmi");
		cap.setCapability("chromedriverExecutable", "/Users/balaji/Downloads/chromedriver_mac64/chromedriver");
		

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	
		driver.activateApp("com.docusign.ink");
//		com.docusign.ink.HomeActivity
		
		driver.findElement(AppiumBy.xpath("//*[@text='Log In']")).click();
		
		Thread.sleep(10000);
		
		System.out.println(driver.getContextHandles());
		driver.context("WEBVIEW_chrome");
//		https://account.docusign.com/oauth/auth?redirect_uri=docusign%3A%2F%2Foauth%2Fcb&client_id=ae021dda-cde0-4f44-a63c-bb9e29119600&response_type=code&ui_locales=en_US&state=jNaZcuM4_WFnXscccbcxdQ&nonce=0firPDrx24Oon2KHFnOZ_w&scope=signature%20extended&code_challenge=HIlm2b-M3TKo3TkoxVKZGQeq-3ovetVVeEzW3eErKKU&code_challenge_method=S256&DS_A=8708276b-2bd1-4dbe-b310-78f8a18b6b8c&ui_flavors=no_footer%20no_cancellation%20no_sign_up%20no_advertisement
	
//		<input aria-required="true" data-qa="username" aria-describedby="fixtureErrors" autocapitalize="off" autocomplete="username" id="cNvJPKYt5A" placeholder="Enter email" name="email" spellcheck="false" required="" type="email" class="css-tciorg" value="">
	
		driver.findElement(AppiumBy.xpath("//*[@data-qa='username']")).sendKeys("hello@gmail.com");
		
//		<button data-qa="submit-username" class="olv-button olv-ignore-transform css-1m5o92u" type="submit" style="width: 100%;"><span data-qa="submit-username-text" class="css-1ixbp0l">NEXT</span></button>
		driver.findElement(AppiumBy.xpath("//*[@data-qa='submit-username']")).click();
		
	
	
	}

}
