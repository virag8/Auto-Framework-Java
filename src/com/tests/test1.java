package com.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actions.flightActions;
import com.actions.searchActions;
import com.framework.FrameworkException;
import com.framework.LogLevel;
import com.framework.MyLogger;
import com.framework.Selenium;

import pageFactory.GoogleHomePage;

public class test1 {

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
	public void testSearchTextScenario() throws FrameworkException {
		try {
			System.out.println("testSearchTextScenario");
			// searchActions.search("Pune");
			new GoogleHomePage().search("Pune");
			MyLogger.write(LogLevel.INFO, "testSearchTextScenario");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new FrameworkException(e);
		}
	}

	@Test(priority = 2)
	public void testSearchTextNegativeScenario() throws FrameworkException {
		try {
			System.out.println("testSearchTextNegativeScenario");
			searchActions.search("$#@^&!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new FrameworkException(e);
		}
	}

	@Test(priority = 3)
	public void testSearchTextNoBrowserScenario() throws FrameworkException {
		try {
			System.out.println("testSearchTextNoBrowserScenario");
			Selenium.quit();
			searchActions.search("$#@^&!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new FrameworkException(e);
		}
	}

	@Test(priority = 4)
	public void testSearchTextNoBrowserScenario1() throws FrameworkException {
		try {
			System.out.println("testSearchTextNoBrowserScenario1");
			searchActions.search("$#@^&!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new FrameworkException(e);
		}
	}

	@Test(enabled = false)
	public void test11() {
		System.out.println("test11");

		flightActions.searchFlight();

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
