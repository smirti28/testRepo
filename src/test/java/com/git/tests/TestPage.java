package com.git.tests;

import com.git.library.ControlPage;
import com.git.pages.HomePage;

public class TestPage extends ControlPage {
	HomePage myHomePage = new HomePage();

	public void testpage() {
		myHomePage.getWebsite();
	}

}
