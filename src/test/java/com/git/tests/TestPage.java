package com.git.tests;

import org.testng.annotations.Test;

import com.git.library.ControlPage;
import com.git.pages.HomePage;

public class TestPage extends ControlPage {
	HomePage myHomePage = new HomePage();

	@Test
	public void testpage() {
		myHomePage.getWebsite();
		myHomePage.searchObject("Object");
		System.out.println("This is for testing git webhook");
	}

}
