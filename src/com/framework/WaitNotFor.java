package com.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitNotFor {
	private static final int defaultTimeout = 60;

	public WaitNotFor() {
		// TODO Auto-generated constructor stub
	}

	public static boolean NotExist(By by, int[] timeoutSec) {
		boolean elementFound = false;
		int timeout = timeoutSec.length != 0 ? defaultTimeout : timeoutSec[0];

		WebDriverWait wait = new WebDriverWait(Selenium.driver, timeout);
		wait.withMessage("mytimeout");
		elementFound = wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(by)));
		return elementFound;
	}

	public static boolean NotVisible(By by, int[] timeoutSec) {
		boolean elementFound = false;
		int timeout = timeoutSec.length != 0 ? defaultTimeout : timeoutSec[0];

		WebDriverWait wait = new WebDriverWait(Selenium.driver, timeout);
		wait.withMessage("mytimeout");
		elementFound = wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfAllElementsLocatedBy(by)));
		return elementFound;
	}

	public static boolean NotClickable(By by, int[] timeoutSec) {
		boolean elementFound = false;
		int timeout = timeoutSec.length != 0 ? defaultTimeout : timeoutSec[0];

		WebDriverWait wait = new WebDriverWait(Selenium.driver, timeout);
		wait.withMessage("looking for element: " + by);
		elementFound = wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
		return elementFound;
	}

}
