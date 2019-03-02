package com.git.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class ControlPage {
	public static WebDriver driver;

	@BeforeClass
	public void beforeAllTestStart() {

	}

	@AfterClass
	public void afterAllTestEnd() {

	}

	@BeforeMethod
	public void beforeEachTestStart() {
		DesiredCapabilities cap = null;
		cap = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterEachTestEnds() {
		try {
			Thread.sleep(5 * 1000);
			driver.close();
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
