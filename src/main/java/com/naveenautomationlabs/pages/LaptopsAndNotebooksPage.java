package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class LaptopsAndNotebooksPage extends TestBase {
	

	public LaptopsAndNotebooksPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "ul.breadcrumb>li:nth-of-type(2)>a")
	WebElement pageLink;

	public String getTitleDisplayed() {
		return pageLink.getText();

	}
	

}
