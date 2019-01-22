package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.framework.Selenium;

public class searchActions {
	public static void search(String text) {
		Selenium.driver.get("https://www.google.com/");
		
		Selenium.getElement(By.name("q")).sendKeys(text);
		
		Selenium.getElement(By.name("btnK")).click();
		
		WebElement element = Selenium.getElement(By.xpath("//span[contains(text(), 'More for Pune')]"));
		System.out.println(element.getText());
	}
}
