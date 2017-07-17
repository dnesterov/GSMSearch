package gsmserver_com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Add_Item_To_Cart {

public WebDriver driver;

@BeforeMethod
public void openDriver(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
	}

@AfterMethod 
public void closeDriver(){
	driver.close();
	driver.quit();
	}

@Test public void Add_Item_ToCart() throws InterruptedException{
	
    //Opening URL
	driver.navigate().to("https://www.gsmserver.com");
    driver.manage().window().maximize();
	System.out.println("Web Site opened");

    //Locating search search field and searching for the item
    WebElement searchField = driver.findElement(By.cssSelector("input.hide-outline"));
    searchField.clear();
    searchField.sendKeys("iPhone Car Dock Dension IPH1CR0");
	System.out.println("Searchable item entered");
	
	//Click Search button
	driver.findElement(By.cssSelector("a.search-input-button.search-input-submit")).click();
	System.out.println("Search button clicked");
	
	//Click add to cart
	driver.findElement(By.cssSelector("a.product-button.ga-add-to-cart")).click();
	System.out.println("Add to cart button clicked");
	Thread.sleep(2000);
	
	//Proceed to CART
	driver.findElement(By.cssSelector("div.cart")).click();
	Thread.sleep(2000);
	
	//Verify that cart has one item
	Assert.assertTrue(driver.findElement(By.xpath("//a[@data-cart-quantity='1']")).isDisplayed(), "WRONG quantati in the cart");
	System.out.println("CORRECT quantaty is added to the cart");
	
	//Verify that item in the cart is the same as added
	Assert.assertTrue(driver.findElement(By.id("product_item_828684")).isDisplayed(), "Cart has WRONG item");
	System.out.println("Item in the cart is the same as choosen");
	

}
	}
	
	
