package com.brillio.appiumserver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
/**
 * //appium server installed via npm will get start with port as 4723
		//will not work in latest version because we need set the base path /wd/hub
		//so ignore
 * @author balaji
 *
 */
public class Demo1AppiumServerDefaultMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//appium server installed via npm will get start with port as 4723
		//will not work in latest version because we need set the base path /wd/hub
		//so ignore
		AppiumDriverLocalService service= AppiumDriverLocalService.buildDefaultService();
		
		service.start();
		
		
		System.out.println(service.getUrl());
		System.out.println(service.isRunning());
		
		service.stop();
		
		
		
		
		
	}

}
