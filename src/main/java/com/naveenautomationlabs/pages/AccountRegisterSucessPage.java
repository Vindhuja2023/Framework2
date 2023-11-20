package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class AccountRegisterSucessPage extends TestBase {
	public AccountRegisterSucessPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content > h1")
	WebElement registerAccountSuccessText;
	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	public String getRegisterAccountSuccessText() {
		return registerAccountSuccessText.getText();
	}

	public AccountPage clickContinueBtn() {
		continueBtn.click();
		return new AccountPage();
	}

}
