package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By search=By.xpath("//input[@type='search']");
	By productName=By.cssSelector("h4.product-name");
	By topDeals=By.linkText("Top Deals");
	By quantity=By.xpath("//input[@type='number']");
	By addButton=By.xpath("//button[normalize-space()='ADD TO CART']");
	By cart=By.xpath("//a[@class='cart-icon']");
	By checkoutButton=By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");
	By plusIcon=By.xpath("//a[@class='increment']");
	
	
	
	
	
	public void searchItem(String shortName)
	{
		driver.findElement(search).sendKeys(shortName);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText().split("-")[0].trim();

	}
	
	public void selectTopDeals()
	{
		driver.findElement(topDeals).click();
	}
	
	
	public void addQuantity(int qty)
	{
		//driver.findElement(quantity).clear();
		//driver.findElement(quantity).sendKeys(qty);
		//System.out.println("Quantity increased to : +" +qty);
		
		int i = qty-1;
		while(i>0)
		{
			driver.findElement(plusIcon).click();
			i--;
		}
		
	}
	
	public void addProduct()
	{
		driver.findElement(addButton).click();
		System.out.println("Added to the cart");
	}
	
	
	public void proceedTOCheckout() throws InterruptedException
	{
		driver.findElement(cart).click();
		System.out.println("Cart button is clicked");
		driver.findElement(checkoutButton).click();
	//	Thread.sleep(20000);
		System.out.println("Checkout button is clicked");
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
}
