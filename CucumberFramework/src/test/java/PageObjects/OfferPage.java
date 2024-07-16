package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	
	public WebDriver driver;
	
	public OfferPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By searchProduct = By.xpath("//input[@type='search']");
	By productName=By.cssSelector("tr td:nth-child(1)");
	
	
	
	public void searchItem(String shortName)
	{
		driver.findElement(searchProduct).sendKeys(shortName);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();

	}
	
	public void checkNewOffer()
	{
		System.out.println("This is test Message");
	}

}
