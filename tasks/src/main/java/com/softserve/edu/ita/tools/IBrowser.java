package com.softserve.edu.ita.tools;

import org.openqa.selenium.WebDriver;

public interface IBrowser {

	WebDriver getWebDriver();

	String getWebDriverName();

	void quit();

}
