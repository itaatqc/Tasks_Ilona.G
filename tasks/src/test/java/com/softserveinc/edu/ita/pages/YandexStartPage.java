package com.softserveinc.edu.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.ita.tools.ContextVisible;

public class YandexStartPage {
	private WebElement weatherLink;

	public YandexStartPage() {
		this.weatherLink = ContextVisible.get().getVisibleWebElement(
				By.partialLinkText("Погода"));
	}

	public WebElement getWeatherLink() {
		return this.weatherLink;
	}

	public WeatherPage weatherLinkClick() {
		this.weatherLink.click();
		return new WeatherPage();
	}
}
