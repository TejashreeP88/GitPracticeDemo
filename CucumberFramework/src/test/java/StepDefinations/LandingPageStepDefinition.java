package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.PageObjectManager;
import Utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	//public WebDriver driver=null;
	//String landingPageProductName;
	//String offerPageproductName;
	
	TestContextSetup textcontextsetup;
	PageObjectManager pageObjectManager;
	LandingPage lp;
	
	// below is the parameterized constructor, Passing the instance of the class TestContextSetup. 
	// Scope of this instance is limited within the constructor only.
	// to make it public, create a global variable and assign the instance
	
	public LandingPageStepDefinition(TestContextSetup textcontextsetup)
	{
		this.textcontextsetup=textcontextsetup;
		lp = textcontextsetup.pageObjectManager.getLandingPage();
	}
	
	
	
	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() throws IOException {
	
		//textcontextsetup.testBase.WebDriverManager();
		Assert.assertTrue(lp.getTitle().contains("GreenKart"));
	   
	}
	@When("^User search with shortname (.+) and extract the actual name of the product$")
	public void user_search_with_shortname_and_extract_the_actual_name_of_the_product(String shortName) throws InterruptedException {			
		
		lp.searchItem(shortName);
		Thread.sleep(2000);
		textcontextsetup.landingPageProductName= lp.getProductName();
	   System.out.println("Product Name extracted from the landing Page : "+textcontextsetup.landingPageProductName);
	}
	
	
	@Then("^User add quantities (.+) of the searched product$")
	public void user_add_quantities_of_the_searched_product(String quantity) {
	
		lp.addQuantity(Integer.parseInt(quantity));
	}
	@Then("Add the product into the cart")
	public void add_the_product_into_the_cart() {
		
		lp.addProduct();
	}
	@Then("User Proceeds to the checkout page")
	public void user_proceeds_to_the_checkout_page() throws InterruptedException {
		
		lp.proceedTOCheckout();
	}
	

}
