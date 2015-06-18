package com.softserveinc.edu.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.ita.tools.ContextVisible;

public class YandexStartPage {
	private WebElement weather;
	private WebElement comment;
	private WebElement tempDay;
	private WebElement tempNight;
	private WebElement enterLink;

	public YandexStartPage() {
		this.weather = ContextVisible.get().getVisibleWebElement(
				By.partialLinkText("Погода"));
		this.comment = ContextVisible.get().getVisibleWebElement(
				By.xpath("//*[@id='widgets-4-0']/div/div/div[1]/a[2]"));
		this.tempDay = ContextVisible.get().getVisibleWebElement(
				By.xpath("//*[@id='widgets-4-0']/div/div/div[2]/a[1]"));
		this.tempNight = ContextVisible.get().getVisibleWebElement(
				By.xpath("//*[@id='widgets-4-0']/div/div/div[2]/a[2]"));
		
		this.enterLink = ContextVisible.get().getVisibleWebElement(
				By.partialLinkText("Увійти"));
	}

	public WebElement getWeather() {
		return this.weather;
	}
	public WebElement getComment() {
		return this.comment;
	}
	public WebElement getTempDay() {
		return this.tempDay;
	}
	public WebElement getTempNight() {
		return this.tempNight;
	}
	public WebElement getEnterLink() {
		return this.enterLink;
	}
	
	
//
//	public WeatherPage weatherLinkClick() {
//		this.weatherLink.click();
//		return new WeatherPage();
//	}
	
	public LoginMailPage enterLinkClick() {
		this.enterLink.click();
		return new LoginMailPage();
	}
}
