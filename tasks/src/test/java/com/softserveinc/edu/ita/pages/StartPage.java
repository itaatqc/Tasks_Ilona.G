package com.softserveinc.edu.ita.pages;

import com.softserve.edu.ita.tools.IBrowser;
import com.softserve.edu.ita.tools.WebDriverUtils;

public class StartPage extends YandexStartPage {
	private StartPage() {
		super();
	}

	public static StartPage load(IBrowser browser, String url) {
		WebDriverUtils.get(browser).load(url);
		return new StartPage();
	}

}
