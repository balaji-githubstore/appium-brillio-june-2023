package com.brillio.ios;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class Demo5MobileCommands {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("deviceName", "iPhone 14 Pro Max");
		cap.setCapability("platformVersion", "16.4");
//		cap.setCapability("automationName", "XCUITestDriver");
		
		//to open app - get the bundleId from development team
		cap.setCapability("bundleId", "com.apple.Health");


		IOSDriver driver = new IOSDriver(new URL("http://localhost:7989/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//starts the recording
		driver.startRecordingScreen();

		HashMap<String, String> map1=new  HashMap<String, String>();
		map1.put("bundleId", "com.apple.Health");

		String result=driver.executeScript("mobile: isAppInstalled", map1).toString();
		System.out.println(result);
		
		result=driver.executeScript("mobile: deviceInfo").toString();
		System.out.println(result);
		
		result=driver.executeScript("mobile: getDeviceTime").toString();
		System.out.println(result);
		
//		result=driver.executeScript("mobile: isKeyboardShown").toString();
//		System.out.println(result);
//		Only tap, scroll, selectPickerWheelValue, swipe, pinch, doubleTap, twoFingerTap, tapWithNumberOfTaps, touchAndHold, dragFromToForDuration, rotateElement, alert, setPasteboard, getPasteboard, source, getContexts, installApp, isAppInstalled, removeApp, launchApp, terminateApp, queryAppState, activateApp, listApps, viewportScreenshot, viewportRect, startPerfRecord, stopPerfRecord, installCertificate, startLogsBroadcast, stopLogsBroadcast, batteryInfo, deviceInfo, getDeviceTime, activeAppInfo, deviceScreenInfo, pressButton, enrollBiometric, sendBiometricMatch, isBiometricEnrolled, clearKeychains, getPermission, setPermission, resetPermission, getAppearance, setAppearance, siriCommand, deleteFile, deleteFolder, startAudioRecording, stopAudioRecording, runXCTest, installXCTestBundle, listXCTestBundles, listXCTestsInTestBundle, pushNotification, expectNotification, performIoHidEvent, configureLocalization, resetLocationService commands are supported.
		
		
		driver.executeScript("mobile: terminateApp", map1);
		
	
		String encodedString=driver.stopRecordingScreen();
		
		//decode the encodedstring and save it as .mp4
		
		//will start 11 PM IST
		
		
//		mobile: hideKeyboard
		driver.quit();
 	}

}
