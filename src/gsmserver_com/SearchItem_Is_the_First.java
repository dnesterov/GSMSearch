package gsmserver_com;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.Iterables;


public class SearchItem_Is_the_First {

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

@Test public void itemSearch_via_Search() throws InterruptedException{
	
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
	
	//Listing Search result
	List<WebElement> searchResults = driver.findElements(By.cssSelector("div.main-info"));	
	WebElement firstitem = Iterables.getFirst(searchResults, driver.findElement(By.xpath("//li[@data-id= '828684']")));
				 
	//Verify that searchable item is the first in results
	Assert.assertTrue(firstitem.isDisplayed(), "iPhone Car Dock Dension IPH1CR0 is NOT the first ");
	System.out.println("iPhone Car Dock Dension IPH1CR0 is the FIRST in the list");


}
	}
	
	
