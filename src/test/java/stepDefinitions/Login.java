package stepDefinitions;

import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pageObjectModel.AccountPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import utils.CommonUtils;

public class Login {
	
	WebDriver driver;
	private HomePage homepage;
	private LoginPage loginpage;
	private AccountPage accountpage;

	
	@Given("User has navigated to login page")
	public void User_has_navigated_to_login_page() {
		
		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);

		homepage.clickOnMyAccount();
		loginpage = homepage.selectLoginOption();
	}
	
	@When("^User enters valid email address (.*) and valid password (.*)$")
	public void User_enters_valid_email_address_and_valid_password(String valid_email, String valid_password) {

		//loginpage = new LoginPage(driver);

		loginpage.enterEmail(valid_email);
		loginpage.enterPassword(valid_password);
		
		/*
		 * driver.findElement(By.id("input-email")).sendKeys(valid_email);
		 * driver.findElement(By.id("input-password")).sendKeys(valid_password);
		 */
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	   
		accountpage = loginpage.clickOnLoginButton();
		
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("User should get logged in successfully")
	public void user_should_get_logged_in_successfully() {
	 
		//accountpage = new AccountPage(driver);

		boolean displayed = accountpage.displayStatusOfEditYourAccountInfoOption();
		Assert.assertTrue(displayed);
	}

	@When("User enters invalid email address and invalid password {string}")
	public void user_enters_invalid_email_address_and_invalid_password(String invalid_password) {
		
		//loginpage = new LoginPage(driver);

		loginpage.enterEmail(CommonUtils.getEmailwithTimeStamp());
		loginpage.enterPassword(invalid_password);
		
		/*
		 * driver.findElement(By.id("input-email")).sendKeys(getEmailwithTimeStamp());
		 * driver.findElement(By.id("input-password")).sendKeys(invalid_password);
		 */
	}

	@Then("User should get proper warning message")
	public void user_should_get_proper_warning_message() {
	   
		String warning_msg = loginpage.getWarningMessageText();
		Assert.assertTrue(warning_msg.contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User enters valid email address {string} and invalid password {string}")
	public void user_enters_valid_email_address_and_invalid_password(String valid_email, String invalid_password) {
	    
		//loginpage = new LoginPage(driver);

		loginpage.enterEmail(valid_email);
		loginpage.enterPassword(invalid_password);
		
		/*
		 * driver.findElement(By.id("input-email")).sendKeys(valid_email);
		 * driver.findElement(By.id("input-password")).sendKeys(invalid_password);
		 */
	}

	@When("User enters invalid email address and valid password {string}")
	public void user_enters_invalid_email_address_and_valid_password(String valid_password) {
	 
		loginpage.enterEmail(CommonUtils.getEmailwithTimeStamp());
		loginpage.enterPassword(valid_password);
		
		/*
		 * driver.findElement(By.id("input-email")).sendKeys(CommonUtils.
		 * getEmailwithTimeStamp());
		 * driver.findElement(By.id("input-password")).sendKeys(valid_password);
		 */
	}

	@When("User dont enter email address and password")
	public void user_dont_enter_email_address_and_password() {
		
		loginpage.enterEmail("");
		loginpage.enterPassword("");
		
		/*
		 * driver.findElement(By.id("input-email")).sendKeys("");
		 * driver.findElement(By.id("input-password")).sendKeys("");
		 */
	}

	
}
