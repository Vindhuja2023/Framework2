package com.naveenautomationlabs.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlabs.browserUtils.Browser;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.enums.TopNavBar;
import com.naveenautomationlabs.environment.Environment;
import com.naveenautomationlabs.utils.WebDriverEvents;

public class TestBase {

	public static WebDriver wd;

	private final Browser DEFAULT_BROWSER = Browser.CHROME;
	private final Environment URL = Environment.PROD;
	private static final boolean RUN_ON_GRID = false;

	public static Logger logger;
	public  WebDriverListener events;

	@BeforeClass
	public void loggerSetup() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}

	public void setup() {
		if (RUN_ON_GRID) {
			try {
				wd = new RemoteWebDriver(new URL("http://192.168.2.11:4444"), getOption());

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		else {

			switch (DEFAULT_BROWSER) {
			case CHROME:
				wd = new ChromeDriver();
				break;
			case EDGE:
				wd = new EdgeDriver();
				break;
			case FIREFOX:
				wd = new FirefoxDriver();
				break;
			default:
				throw new IllegalArgumentException();
			}
		}

		events = new WebDriverEvents();
		wd = new EventFiringDecorator<WebDriver>(events).decorate(wd);

		wd.get(URL.getUrl());

		wd.manage().window().maximize();
		wd.manage().deleteAllCookies();

		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void selectingSideNavMenu(SideNavMenu menuSelected) {
		List<WebElement> sideNavMenu = wd.findElements(By.cssSelector("div.list-group>a"));
		for (int i = 0; i < sideNavMenu.size(); i++) {
			if (sideNavMenu.get(i).getText().toString().equals(menuSelected.getSideNavMenu())) {
				sideNavMenu.get(i).click();
				break;

			}
		}

	}

	public void selectingTopNavBar(TopNavBar itemSelected, WebElement element) {
		List<WebElement> topNavBar = wd.findElements(By.cssSelector("nav#menu>div:nth-of-type(2)>ul>li"));
		for (int i = 0; i < topNavBar.size(); i++) {
			System.out.println(topNavBar.get(i).getText().toString());
			if (topNavBar.get(i).getText().toString().equals(itemSelected.getTopNavBar())) {
				topNavBar.get(i).click();
				element.click();
				break;

			}
		}

	}

	public void selectFromDropDown(WebElement element, String visibleText) {

		Select sc = new Select(element);
		sc.selectByVisibleText(visibleText);

	}

	public MutableCapabilities getOption() {
		return new ManageOptions().getOption(DEFAULT_BROWSER);
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
}
