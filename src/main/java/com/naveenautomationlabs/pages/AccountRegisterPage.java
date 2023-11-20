package com.naveenautomationlabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.base.TestBase;

public class AccountRegisterPage extends TestBase {

	public AccountRegisterPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-firstname")
	WebElement inputFirstName;

	@FindBy(id = "input-lastname")
	WebElement inputLastName;
	@FindBy(id = "input-email")
	WebElement inputEmail;
	@FindBy(id = "input-telephone")
	WebElement inputTelephone;
	@FindBy(id = "input-password")
	WebElement inputPassword;
	@FindBy(id = "input-confirm")
	WebElement inputConfirmPassword;
	@FindBy(css = "input[type='checkbox']")
	WebElement privacyPolicyCheckBox;
	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;
	@FindBy(css = "#content > h1")
	WebElement registerAccountText;
	@FindBy(css = "div.text-danger")
	WebElement warningText;
	@FindBy(css = "div.alert-danger")
	WebElement alertText;


	private void enterFirstName(String firstName) {
		inputFirstName.sendKeys(firstName);
	}

	private void enterLastName(String lastName) {
		inputLastName.sendKeys(lastName);
	}

	private void enterEmail(String email) {
		inputEmail.sendKeys(email);

	}

	private void enterTelephone(String telephone) {
		inputTelephone.sendKeys(telephone);

	}

	private void enterPassword(String password) {
		inputPassword.sendKeys(password);
	}

	private void enterConfirmPassword(String confirmPassword) {
		inputConfirmPassword.sendKeys(confirmPassword);
	}

	public void checkPrivacyPolicyCheckBox() {
		privacyPolicyCheckBox.click();

	}

	public AccountRegisterSucessPage clickContinueBtn(String firstName, String lastName, String email, String telephone,
			String password, String confirmPassword) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterTelephone(telephone);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
		checkPrivacyPolicyCheckBox();
		continueBtn.click();
		return new AccountRegisterSucessPage();
	}

	public String getRegisterAccountText() {
		return registerAccountText.getText();
	}

	public String getWarningText() {
		return warningText.getText();
	}

	public String getAlertText() {
		return alertText.getText();
	}

}
