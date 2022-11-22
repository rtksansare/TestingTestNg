import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalTesting extends CommonMethods{
	@Test
	public void loginWithCorrectCredentials() {
		WebElement username=driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		username.sendKeys("standard_user");
		waitMethod(3000);
		
		WebElement password=driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("secret_sauce");
		waitMethod(3000);
		
		WebElement loginButton=driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		loginButton.click();
		waitMethod(3000);
		}
	
	@Test(dependsOnMethods = "loginWithCorrectCredentials") 
	public void openPerticularProductPage() {
		WebElement sauceLabsBackpack=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]"));
		sauceLabsBackpack.click();
		waitMethod(3000);
	}
	
	@Test(dependsOnMethods = "openPerticularProductPage") 
	public void addProductToCartFromProductPage() {
		WebElement addToCart=driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
		addToCart.click();
		waitMethod(3000);
	}
	
	@Test(dependsOnMethods = "addProductToCartFromProductPage") 
	public void openCartAndCheckout() {
		WebElement cart=driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
		cart.click();
		WebElement checkout=driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
		checkout.click();
		waitMethod(3000);
		
		WebElement fname=driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
		WebElement lname=driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
		WebElement zipcode=driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
		fname.sendKeys("Rutik");
		lname.sendKeys("Sansare");
		zipcode.sendKeys("560103");
		waitMethod(3000);
		
		WebElement continueButton=driver.findElement(By.xpath("//*[@id=\"continue\"]"));
		continueButton.click();
		waitMethod(3000);
		
		//Finish Button
		WebElement finishButton=driver.findElement(By.xpath("//*[@id=\"finish\"]"));
		finishButton.click();
		waitMethod(2);
		
		//Return to Home Screen
		WebElement backHome=driver.findElement(By.xpath("//*[@id=\"back-to-products\"]"));
		backHome.click();
		waitMethod(5);
		
	}
	
	
	
	
}
