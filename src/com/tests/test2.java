package com.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actions.searchActions;
import com.framework.FrameworkException;
import com.framework.LogLevel;
import com.framework.MyLogger;
import com.framework.Selenium;

public class test2 {
	@BeforeClass
	public void beforeClass() throws FrameworkException {
		try {
			Selenium.chromelaunch();
		} catch (Exception e) {
			// TODO: handle exception
			throw new FrameworkException(e);
		}

	}

	@Test(priority = 1)
	public void testSearchTextScenario1() throws FrameworkException {
		try {
			System.out.println("testSearchTextScenario1");
			searchActions.search("Pune");
			MyLogger.write(LogLevel.INFO, "testSearchTextScenario1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new FrameworkException(e);
		}
	}

	@AfterClass
	public void afterClass() throws FrameworkException {
		try {
			Selenium.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new FrameworkException(e);
		}
	}
}
