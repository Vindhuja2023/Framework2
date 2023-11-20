package com.naveenautomationlabs.testPages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;
import com.naveenautomationlabs.enums.SideNavMenu;
import com.naveenautomationlabs.pages.AccountRegisterPage;
import com.naveenautomationlabs.pages.AccountRegisterSucessPage;
import com.naveenautomationlabs.pages.LoginPage;

public class AccountRegisterPageTest extends TestBase {

	LoginPage loginPage;
	AccountRegisterPage accountRegisterPage;
	AccountRegisterSucessPage accountRegisterSucessPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();
	}

	@Test
	public void validateUserNavigatedToRegisterAccount() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		Assert.assertEquals(accountRegisterPage.getRegisterAccountText(), "Register Account",
				"User is not navigated to Register Account Page");
	}

	@Test
	public void validateUserIsAbleToRegisterWithValidInfo() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		accountRegisterSucessPage = accountRegisterPage.clickContinueBtn("Diya", "Krishna", "diya12@email.com",
				"456776543", "diya@123", "diya@123");

		Assert.assertEquals(accountRegisterSucessPage.getRegisterAccountSuccessText(), "Your Account Has Been Created!",
				"User is not Able To Register With Valid Info");
	}

	@Test
	public void validateUserCanNotSkipFirstName() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		accountRegisterPage.clickContinueBtn("", "Krishna", "diya1256@email.com", "4567760843", "diya@123", "diya@123");

		Assert.assertEquals(accountRegisterPage.getWarningText(), "First Name must be between 1 and 32 characters!",
				"User successfully skipped First Name. Validation failed.");
	}

	@Test
	public void validateUserCanNotSkipLastName() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		accountRegisterPage.clickContinueBtn("diya", "", "diya12@email.com", "456776543", "diya@123", "diya@123");

		Assert.assertEquals(accountRegisterPage.getWarningText(), "Last Name must be between 1 and 32 characters!",
				"User successfully skipped Last Name. Validation failed.");

	}

	@Test
	public void validateUserCanNotEnterInvalidFirstName() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		accountRegisterPage.clickContinueBtn("diyaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Krishna",
				"diya123@gmail.com", "456896543", "diya@123", "diya@123");

		Assert.assertEquals(accountRegisterPage.getWarningText(), "First Name must be between 1 and 32 characters!",
				"User successfully skipped First Name. Validation failed.");
	}

	@Test
	public void validateUserCanNotEnterInvalidLastName() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		accountRegisterPage.clickContinueBtn("diyaa", "Krishnaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"diya12@email.com", "456776543", "diya@123", "diya@123");

		Assert.assertEquals(accountRegisterPage.getWarningText(), "Last Name must be between 1 and 32 characters!",
				"User successfully skipped First Name. Validation failed.");
	}

	@Test
	public void validateUserCanNotSkipEmail() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		accountRegisterPage.clickContinueBtn("diya", "krishna", "", "456776543", "diya@123", "diya@123");
		Assert.assertEquals(accountRegisterPage.getWarningText(), "E-Mail Address does not appear to be valid!",
				"User successfully skipped Email. Validation failed.");
	}

	@Test
	public void validateUserCanNotEnterInvalidTelephone() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		accountRegisterPage.clickContinueBtn("diya", "krishna", "diya123@yahoo.com", "45", "diya@123", "diya@123");
		Assert.assertEquals(accountRegisterPage.getWarningText(), "Telephone must be between 3 and 32 characters!",
				"User successfully skipped Telephone. Validation failed.");
	}

	@Test
	public void validateUserCanNotEnterInvalidPassword() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		accountRegisterPage.clickContinueBtn("diya", "krishna", "diya123@gmail.com", "456776543", "d", "d");
		Assert.assertEquals(accountRegisterPage.getWarningText(), "Password must be between 4 and 20 characters!",
				"User successfully skipped Password. Validation failed.");
	}

	@Test
	public void validateUserCanNotSkipPassword() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		accountRegisterPage.clickContinueBtn("diya", "krishna", "diya123@email.com", "456776543", "", "");
		Assert.assertEquals(accountRegisterPage.getWarningText(), "Password must be between 4 and 20 characters!",
				"User successfully skipped Password. Validation failed.");
	}

	@Test
	public void validateUserCanNotSkipConfirmPassword() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		accountRegisterPage.clickContinueBtn("diya", "krishna", "diya123@gmail.com", "456776543", "diya@123", "");
		Assert.assertEquals(accountRegisterPage.getWarningText(), "Password confirmation does not match password!",
				"User successfully skipped Confirm Password. Validation failed.");
	}

	@Test
	public void validateUserCheckEDPrivacyPolicyCheckBox() {
		accountRegisterPage = loginPage.clickRegister(SideNavMenu.REGISTER);
		accountRegisterPage.checkPrivacyPolicyCheckBox();
		accountRegisterPage.clickContinueBtn("diya", "krishna", "diya123@gmail.com", "456776543", "diya@123",
				"diya@123");

		Assert.assertEquals(accountRegisterPage.getAlertText(), "Warning: You must agree to the Privacy Policy!",
				"User successfully skipped Privacy PolicyCheck Box. Validation failed.");
	}

}
