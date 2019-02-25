package com.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
	private static final int defaultTimeout = 60;

	public WaitFor() {
		// TODO Auto-generated constructor stub
	}

	public static WebElement Exist(By by, int[] timeoutSec) {
		int timeout = timeoutSec.length != 0 ? defaultTimeout : timeoutSec[0];

		WebDriverWait wait = new WebDriverWait(Selenium.driver, timeout);
		wait.withMessage("mytimeout");
		List<WebElement> element = wait
				.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(by)));
		return element.get(0);
	}

	public static WebElement Visible(By by, int[] timeoutSec) {
		WebElement element = null;
		int timeout = timeoutSec.length != 0 ? defaultTimeout : timeoutSec[0];

		WebDriverWait wait = new WebDriverWait(Selenium.driver, timeout);
		wait.withMessage("mytimeout");
		element = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
		return element;
	}

	public static WebElement Clickable(By by, int[] timeoutSec) {
		WebElement element = null;
		int timeout = timeoutSec.length != 0 ? defaultTimeout : timeoutSec[0];

		WebDriverWait wait = new WebDriverWait(Selenium.driver, timeout);
		wait.withMessage("mytimeout");
		element = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
		return element;
	}

}
