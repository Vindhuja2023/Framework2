package com.naveenautomationlabs.testPages;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.base.TestBase;

import com.naveenautomationlabs.enums.TopNavBar;
import com.naveenautomationlabs.pages.AccountPage;
import com.naveenautomationlabs.pages.LaptopsAndNotebooksPage;
import com.naveenautomationlabs.pages.LoginPage;


public class LaptopsAndNotebooksPageTest extends TestBase {

	private LoginPage loginPage;
	private AccountPage accountPage;
	private LaptopsAndNotebooksPage laptopsAndNotebookPage;

	@BeforeMethod
	private void launch() {
		setup();
		loginPage = new LoginPage();

	}
	@Test
	public void validateUserCanOpenLaptopAndNotebookPage() {
		accountPage = loginPage.submitLogin("jane123@email.com", "jane@123");
		laptopsAndNotebookPage = accountPage.clickLaptopsAndNotebooks(TopNavBar.LAPTOPS_AND_NOTEBOOKS);
		assertEquals(laptopsAndNotebookPage.getTitleDisplayed(),"Laptops & Notebooks","Title of the page Laptop And Notebooks as not as expected");
	}


}
