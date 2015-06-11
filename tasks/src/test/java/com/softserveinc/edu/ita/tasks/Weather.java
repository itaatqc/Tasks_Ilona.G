package com.softserveinc.edu.ita.tasks;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.ita.tools.BrowserRepository;
import com.softserve.edu.ita.tools.IBrowser;
import com.softserve.edu.ita.tools.WebDriverUtils;
import com.softserveinc.edu.ita.pages.StartPage;
import com.softserveinc.edu.ita.pages.WeatherPage;
import com.softserveinc.edu.ita.pages.YandexStartPage;

public class Weather {

	@DataProvider
	public Object[][] firstTest() {
		return new Object[][] { {
				BrowserRepository.getFirefoxByTemporaryProfile(),
				"http://www.yandex.ru/" } };
	}

	@Test(dataProvider = "firstTest")
	public void firstTest(IBrowser browser, String url) {
		// Load yandex.ru
		YandexStartPage yandexStartPage = StartPage.load(browser, url);

		// Click on weatherLink
		WeatherPage weatherPage = yandexStartPage.weatherLinkClick();

		// Get text of today's weather
		StringBuilder forecast = new StringBuilder();
		forecast.append(weatherPage.getDay().getText() + "\n");
		forecast.append(weatherPage.getComment().getText() + "\n");
		forecast.append(weatherPage.getTempDay().getText() + "\n");
		forecast.append(weatherPage.getTempNight().getText() + "\n");

		// Send forecast to email
		weatherPage.sendMail(forecast);
	}

	// Return to previous state
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		WebDriverUtils.get().stop();
	}
}