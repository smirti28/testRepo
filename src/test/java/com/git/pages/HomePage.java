package com.git.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.git.library.ControlPage;

public class HomePage extends ControlPage {
	public HomePage getWebsite() {
		driver.get("https://www.google.com/");
		return this;
	}

	public HomePage searchObject(String searchText) {
		try {
			WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
			searchBox.clear();
			searchBox.sendKeys(searchText);
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("input[name='btnK']")).click();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
}
