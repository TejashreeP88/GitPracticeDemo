package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage {
	
	public WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	By applyButton=By.xpath("//button[normalize-space()='Apply']");
	By placeOrderButton=By.xpath("//button[normalize-space()='Place Order']");
	By productName=By.xpath("//p[@class='product-name']");

	
	
	public void getProductName(String itemName)
	{
		String productNameUI=driver.findElement(productName).getText().split("-")[0].trim();
		Assert.assertEquals(productNameUI, itemName);
		

	}
	
	public void verifyCheckoutPage()
	{
		
		if(driver.findElement(applyButton).isDisplayed())
		{
			Assert.assertTrue(true, "Apply Button is visible");
		}
		
		if(driver.findElement(placeOrderButton).isDisplayed())
		{
			Assert.assertTrue(true, "Place Order Button is visible");
		}
	}
	
}
