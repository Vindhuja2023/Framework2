package com.naveenautomationlabs.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.naveenautomationlabs.base.TestBase;

public class WebDriverEvents extends TestBase implements WebDriverListener {

	@Override
	public void beforeAccept(Alert alert) {
		logger.info(alert + "alert before accepting.");
	}

	@Override
	public void afterAccept(Alert alert) {
		logger.info("Accepted Alerts" + alert);
	}

	@Override
	public void afterDismiss(Alert alert) {
		logger.info("Dismissed Alert" + alert);
	}

	@Override
	public void beforeTo(WebDriver.Navigation navigation, String url) {
		logger.info("Navigating to url " + url);
	}

	@Override
	public void afterTo(WebDriver.Navigation navigation, String url) {
		logger.info("Navigated to url " + url);
	}

	@Override
	public void afterRefresh(WebDriver.Navigation navigation) {
		logger.info("Page refreshed");
	}

	@Override
	public void beforeGetText(WebElement element) {
		logger.info("Getting text on " + element);
	}

	@Override
	public void afterGetText(WebElement element, String result) {
		logger.info("Got text " + result + " on " + element);
	}

	@Override
	public void beforeFindElement(WebElement element, By locator) {
		logger.info("Finding element " + element + " using " + locator);
	}

	@Override
	public void afterFindElement(WebElement element, By locator, WebElement result) {
		logger.info("Found element " + element + " using " + locator);
	}

	@Override
	public void beforeClick(WebElement element) {
		logger.info("Clicking element " + element);
	}

	@Override
	public void afterClick(WebElement element) {
		logger.info("Clicked element " + element);
	}

}
