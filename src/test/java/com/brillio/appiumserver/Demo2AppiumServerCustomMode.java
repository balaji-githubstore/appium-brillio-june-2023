package com.brillio.appiumserver;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;

public class Demo2AppiumServerCustomMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//appium server installed via npm will get start available port, collect appium log file
//		AppiumDriverLocalService service= AppiumDriverLocalService.buildDefaultService();
		
		AppiumServiceBuilder builder=new AppiumServiceBuilder();
		builder.usingAnyFreePort();
		
//		builder.usingPort(8989);
//		builder.withIPAddress("192.55.25.111");
		
		
		builder.withLogFile(new File("logs/appiumlog.log"));
		builder.withArgument(GeneralServerFlag.BASEPATH,"/wd/hub");
		
		//below code only for macbook
		builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
		
		
		
		
		AppiumDriverLocalService service=AppiumDriverLocalService.buildService(builder);
		
	
		service.start();
		
		//automation script to connect android or ios device
		System.out.println(service.getUrl());
		System.out.println(service.isRunning());
		
		service.stop();
		
		
		
		
		
	}

}
