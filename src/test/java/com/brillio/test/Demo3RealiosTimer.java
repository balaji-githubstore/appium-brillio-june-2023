package com.brillio.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Demo3RealiosTimer {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("appium:deviceName", "iPad");
		cap.setCapability("appium:platformVersion", "16.5");
		cap.setCapability("udid", "417da800b3114ff6776f5c37c65974d071364376");
		cap.setCapability("automationName", "XCUITest");
		IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.activateApp("com.apple.mobiletimer");
		
		RemoteWebElement element = (RemoteWebElement)driver.findElement(AppiumBy.xpath("//XCUIElementTypePickerWheel"));
		HashMap<String, Object> cmd = new HashMap<String, Object>();
        cmd.put("elementId", element.getId());
        cmd.put("order", "next");
        cmd.put("offset", 0.15);


        driver.executeScript("mobile: selectPickerWheelValue", cmd);
        driver.executeScript("mobile: selectPickerWheelValue", cmd);
        driver.executeScript("mobile: selectPickerWheelValue", cmd);

        element = (RemoteWebElement)driver.findElement(AppiumBy.xpath("(//XCUIElementTypePickerWheel)[2]"));
            
        //element = (IOSElement)driver.FindElementsByXPath("//XCUIElementTypePickerWheel")[1];
        cmd.clear();
        cmd.put("elementId", element.getId());
        cmd.put("order", "next");
        cmd.put("offset", 0.15);


        driver.executeScript("mobile: selectPickerWheelValue", cmd);
        driver.executeScript("mobile: selectPickerWheelValue", cmd);
        driver.executeScript("mobile: selectPickerWheelValue", cmd);

        String value=element.getAttribute("value");
        System.out.println(value);

        element.sendKeys("8 min");

        element = (RemoteWebElement)driver.findElement(AppiumBy.xpath("(//XCUIElementTypePickerWheel)[3]"));
        element.sendKeys("45 sec");
		driver.quit();
	}

}
