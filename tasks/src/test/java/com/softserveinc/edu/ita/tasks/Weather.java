package com.softserveinc.edu.ita.tasks;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.ita.tools.BrowserRepository;
import com.softserve.edu.ita.tools.IBrowser;
import com.softserve.edu.ita.tools.WebDriverUtils;
import com.softserveinc.edu.ita.pages.LetterPage;
import com.softserveinc.edu.ita.pages.LoginMailPage;
import com.softserveinc.edu.ita.pages.MailPage;
import com.softserveinc.edu.ita.pages.StartPage;
import com.softserveinc.edu.ita.pages.YandexStartPage;

import org.apache.log4j.Logger;

public class Weather {
	final static Logger logger = Logger.getLogger(Weather.class);

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

		// Get text of today's weather
		StringBuilder forecast = new StringBuilder();
		forecast.append(yandexStartPage.getWeather().getText() + "\n");
		forecast.append(yandexStartPage.getComment().getAttribute("title")
				.toString()+ "\n");
		forecast.append(yandexStartPage.getTempDay().getText() + "\n");
		forecast.append(yandexStartPage.getTempNight().getText() + "\n");
		logger.info("We have got a today's forecast");

		// Click on enterButton
		LoginMailPage loginMailPage = yandexStartPage.enterLinkClick();
		logger.info("We have clicked on enterButton");

		// Input login data and Enter into Email
		MailPage mailPage = loginMailPage.loginMail();
		logger.info("We have typed login data");

		// Click on writeLetter
		LetterPage letterPage = mailPage.writeLetterClick();
		logger.info("We have clicked on writeLetter");

		// Send forecast to email
		letterPage.sendLetter(forecast);
		logger.info("We have sent Letter!");
	}

	// Return to previous state
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		WebDriverUtils.get().stop();
	}
}