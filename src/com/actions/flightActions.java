package com.actions;

import org.openqa.selenium.By;

import com.framework.Selenium;

public class flightActions {
	public static void searchFlight() {
		Selenium.driver.get("https://www.google.com/flights");
		Selenium.getElement(By.xpath("//div[@data-flt-ve='origin_airport' and @class='flt-input gws-flights-form__input-container gws-flights__flex-box gws-flights-form__airport-input gws-flights-form__swapper-right']"))
		.sendKeys("Pune");
		
		Selenium.getElement(By.xpath("//div[@data-flt-ve='destination_airport' and @class='//div[@data-flt-ve='destination_airport' and @class='flt-input gws-flights-form__input-container gws-flights__flex-box gws-flights-form__airport-input gws-flights-form__empty gws-flights-form__swapper-left']"))
		.sendKeys("New Delhi");
		
		Selenium.getElement(By.xpath("floating-action-button[@data-flt-ve='search_button']")).click();
	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
