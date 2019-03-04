package com.git.library;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

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
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/browser_drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterEachTestEnds(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			captureScreenShot(result.getName(), "target/screenshots/");
		}
		try {
			Thread.sleep(5 * 1000);
			driver.close();
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String captureScreenShot(String screenshotFileName, String filePath) {
		String finalScreenshotPath = null;
		String timeStamp = getCurrentTime();

		try {
			if (!filePath.isEmpty()) {
				checkDirectory(filePath);
				finalScreenshotPath = filePath + screenshotFileName + timeStamp + ".png";
			} else {
				checkDirectory("target/screenshots/");
				finalScreenshotPath = "target/screenshots/" + screenshotFileName + timeStamp + ".png";
			}

			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(srcFile, new File(finalScreenshotPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("screenshot Captured: " + finalScreenshotPath);
		return finalScreenshotPath;
	}

	private String checkDirectory(String inputPath) {
		File file = new File(inputPath);
		String absPath = file.getAbsolutePath();
		File file2 = new File(absPath);
		if (!file2.exists()) {
			if (file2.mkdirs()) {
				System.out.println("Folder created...");
			} else {
				System.out.println("Folder not created...");
			}

		}
		return absPath;
	}

	/***
	 * This method will return you the current time of your system.
	 * 
	 * @return current time as String
	 */
	public String getCurrentTime() {
		String finalTimeStamp = null;
		Date date = new Date();
		String tempTime = new Timestamp(date.getTime()).toString();
		// logger.info("Original TimeStamp: " + tempTime);
		finalTimeStamp = tempTime.replace(":", "_").replace(" ", "_").replace(".", "_").replace("-", "_");
		// logger.info("Updated TimeStamp: " + finalTimeStamp);
		return finalTimeStamp;
	}
}
