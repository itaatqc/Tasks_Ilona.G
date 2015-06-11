package com.softserveinc.edu.ita.pages;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.ita.tools.ContextVisible;


public class WeatherPage {
	private WebElement day;
	private WebElement comment;
	private WebElement tempDay;
	private WebElement tempNight;

	
	public WeatherPage() {
		this.day = ContextVisible
				.get()
				.getVisibleWebElement(
						By.xpath("html/body/div[2]/div[2]/div[2]/div[1]/ul/li[1]/div[1]/span[2]"));
		this.comment = ContextVisible
				.get()
				.getVisibleWebElement(
						By.xpath("html/body/div[2]/div[2]/div[2]/div[1]/ul/li[1]/div[2]/div[1]"));
		this.tempDay = ContextVisible
				.get()
				.getVisibleWebElement(
						By.xpath("html/body/div[2]/div[2]/div[2]/div[1]/ul/li[1]/div[2]/div[2]"));
		this.tempNight = ContextVisible
				.get()
				.getVisibleWebElement(
						By.xpath("html/body/div[2]/div[2]/div[2]/div[1]/ul/li[1]/div[3]"));
	}

	public WebElement getDay() {
		return this.day;
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

	public void sendMail(StringBuilder forecast) {
		final String username = "atqcilona@gmail.com";
		final String password = "Qwerty!@#";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.host", "74.125.143.109");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, null);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("atqcilona@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("atqcilona@gmail.com"));
			message.setSubject("Today's weather");
			message.setText(forecast.toString());

			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", username, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
