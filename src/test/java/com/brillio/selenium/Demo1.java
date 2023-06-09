package com.brillio.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
		List<WebElement> elements= driver.findElements(By.xpath("//a"));
		
		System.out.println(elements.size());
		
//		System.out.println(elements.get(0).getText());
//		System.out.println(elements.get(1).getText());
//		System.out.println(elements.get(2).getText());
		
		for(int i=0;i<elements.size();i++)
		{
			System.out.println(elements.get(i).getText());
		}
	}

}
