package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public WebDriver driver;
	public LandingPage landingPage;	
	public OfferPage offerPage;
	public CheckoutPage checkOutPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver =driver;
	}
		
	
	// a new Method, this method should give the object
	public LandingPage getLandingPage()
	{
		
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	
	public OfferPage getOffertPage()
	{
		
		offerPage = new OfferPage(driver);
		return offerPage;
	}
	
	public CheckoutPage getChekoutPage()
	{
		
		checkOutPage = new CheckoutPage(driver);
		return checkOutPage;
	}

}
