package cpm.brillio.androidassignments;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo2CloudHyundaiSignUpTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		//work only on real or virtual device
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "9.0");
		cap.setCapability("deviceName", "Google Pixel 3");
		cap.setCapability("appium:app", "bs://be22b5cd998c61d1735737678aa2889acc35a342");
		cap.setCapability("autoLaunch", "false");
		HashMap<String, String> bstackDetails = new HashMap<String, String>();
		
		bstackDetails.put("projectName", "BrillioAppiumSessionProject");
		bstackDetails.put("buildName", "BrillioChromeAppiumSessionBuild2");
		bstackDetails.put("sessionName", "BrillioChromeAppiumSession");
		
		bstackDetails.put("userName", "dinakaranbalaji1");
		bstackDetails.put("accessKey", "6yXRE4nK1fyvTHWA2kPD");

		cap.setCapability("bstack:options", bstackDetails);

		AndroidDriver driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		
//		driver.installApp("C:\\Components\\com.bsl.hyundai_2021-08-09.apk");
		
//		driver.activateApp("com.bsl.hyundai");
		
//		if(driver.isAppInstalled("com.bsl.hyundai"))
//		{
//			driver.activateApp("com.bsl.hyundai");
//		}
		
		driver.activateApp("com.bsl.hyundai");
		
		System.out.println(driver.getPageSource());
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='DENY' or @text='Deny']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='DENY' or @text='Deny']")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'SIGN UP')]")).click();
		
		
		driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@resource-id='com.bsl.hyundai:id/edtFullname']")).sendKeys("john");
		
		driver.findElement(AppiumBy.id("com.bsl.hyundai:id/edtMobileNumber")).sendKeys("999898");
		
//		5.	Enter name, mobile number, email id, password, confirm password 
//		6.	Click on check box  
//		7.	No need to click on register 

		driver.quit();
	}

}
