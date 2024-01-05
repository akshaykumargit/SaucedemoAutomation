package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = null;
	
	@SuppressWarnings("deprecation")
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    System.out.println("In Login Step");
	    String projectPath = System.getProperty("user.dir");
	    String driverPath = "/src/test/resources/drivers/chromedriver";
	    System.out.println("Project Path is : "+projectPath);
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+driverPath);
	   
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    
	    driver.navigate().to("https://www.saucedemo.com/");
	    
	    
	    
	}

	@When("user enters username")
	public void user_enters_username() {
		System.out.println("In Enter username");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}

	@And("click on login button")
	public void click_on_login_button() throws InterruptedException {
		System.out.println("In Click on login button");
		driver.findElement(By.id("login-button")).click();;
		Thread.sleep(2000);
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
		System.out.println("In User is navigated to home page");
		driver.findElement(By.id("shopping_cart_container")).isDisplayed();
		
		
	}

	@And("user adds an item into cart")
	public void user_adds_an_item_into_cart() {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		if(driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).isDisplayed())
		{
			driver.findElement(By.id("shopping_cart_container")).click();
		}
		else 
			System.out.println("No item added");
	}

	@And("user clicks on checkout in cart")
	public void user_clicks_on_checkout_in_cart() {
		if(driver.findElement(By.className("title")).isDisplayed())
			driver.findElement(By.id("checkout")).click();
		else
			System.out.println("Items in cart empty");
	}

	@And("user enters delivery details")
	public void user_enters_delivery_details() {
		driver.findElement(By.id("first-name")).sendKeys("Firsttest");
		driver.findElement(By.id("last-name")).sendKeys("Lasttest");
		driver.findElement(By.id("postal-code")).sendKeys("postalcode");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		
	}

	@And("user completes the order successfully")
	public void user_completes_the_order_successfully() throws InterruptedException {
		driver.findElement(By.id("checkout_complete_container")).isDisplayed();
		System.out.println("Transaction scenario complete");
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}




	
}
