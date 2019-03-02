package com.git.pages;

import com.git.library.ControlPage;

public class HomePage extends ControlPage {
	public HomePage getWebsite() {
		driver.get("https://www.google.com/");
		return this;
	}

}
