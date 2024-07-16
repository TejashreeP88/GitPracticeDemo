package StepDefinations;

import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import PageObjects.PageObjectManager;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;

public class CheckoutPageStepDefinition {
	
	TestContextSetup textcontextsetup;
	PageObjectManager pageObjectManager;
	
	// below is the parameterized constructor, Passing the instance of the class TestContextSetup. 
	// Scope of this instance is limited within the constructor only.
	// to make it public, create a global variable and assign the instance
	
	public CheckoutPageStepDefinition(TestContextSetup textcontextsetup)
	{
		this.textcontextsetup=textcontextsetup;
	}
	
	@Then("^Verify the product details (.+) and other information on checkout page$")
	public void verify_the_product_details_tom_and_other_information_on_checkout_page(String itemName) {
		CheckoutPage cp = textcontextsetup.pageObjectManager.getChekoutPage();
		cp.getProductName(itemName);
		cp.verifyCheckoutPage();
	}
	



}
