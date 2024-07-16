package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.OfferPage;
import Utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	//public WebDriver driver;
	//String landingPageProductName;
	String offerPageproductName;
	
	TestContextSetup textcontextsetup;
	
	
	
	
public OfferPageStepDefinition(TestContextSetup setup)
{
	textcontextsetup=setup;
}
	
	@Then("^User go and search for the shortname (.+) in offers page$")
	public void user_go_and_search_for_the_shortname_in_offers_page(String shortName) throws InterruptedException {
		
		switchToOffersPage();
		OfferPage op = textcontextsetup.pageObjectManager.getOffertPage();
		op.searchItem(shortName);
		Thread.sleep(2000);
		offerPageproductName= op.getProductName();
		System.out.println("Product Name extracted from the offer Page : "+offerPageproductName);
		
	    
	}
	
	public void switchToOffersPage()
	{
		
		LandingPage lp = textcontextsetup.pageObjectManager.getLandingPage();
		lp.selectTopDeals();
		textcontextsetup.genericUtils.switchWindowToChild();
		
	}
	
	
	@Then("Validate if product name in offer page matches with landing page")
	public void validate_if_product_name_in_offer_page_matches_with_landing_page() {
	    Assert.assertEquals(textcontextsetup.landingPageProductName, offerPageproductName);
	}

}
