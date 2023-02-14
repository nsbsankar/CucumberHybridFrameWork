package stepDefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjectModel.AccountSuccessPage;
import pageObjectModel.HomePage;
import pageObjectModel.RegisterAccountPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private HomePage homepage;
	RegisterAccountPage registerAccountPage;
	AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);

	@Given("User navigates to Register account page")
	public void user_navigates_to_register_account_page() {

		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerAccountPage = homepage.selectRegisterOption();
		
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
	}

	@When("User enters details into below fields")
	public void user_enters_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerAccountPage.enterFirstName(dataMap.get("firstname"));
		registerAccountPage.enterLastName(dataMap.get("lastname"));
		registerAccountPage.enterEmail(CommonUtils.getEmailwithTimeStamp());
		registerAccountPage.enterTelephone(dataMap.get("telephone"));
		registerAccountPage.enterPassword(dataMap.get("password"));
		registerAccountPage.enterConfirmPassword(dataMap.get("password"));
		
	//	driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
	//	driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
	//	driver.findElement(By.id("input-email")).sendKeys(getEmailwithTimeStamp());
	//	driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
	//	driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	//	driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}

	@When("User enters details into below fields with duplicate email")
	public void user_enters_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerAccountPage.enterFirstName(dataMap.get("firstname"));
		registerAccountPage.enterLastName(dataMap.get("lastname"));
		registerAccountPage.enterEmail(dataMap.get("email"));
		registerAccountPage.enterTelephone(dataMap.get("telephone"));
		registerAccountPage.enterPassword(dataMap.get("password"));
		registerAccountPage.enterConfirmPassword(dataMap.get("password"));
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		//driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}
	@When("User selects privacy policy and clicks on continue button")
	public void user_selects_privacy_policy_and_clicks_on_continue_button() {

		registerAccountPage.clickOnPrivacyPolicy();
		accountSuccessPage = registerAccountPage.clickOnContinueButton();
		
		//driver.findElement(By.name("agree")).click();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {

		String actual = accountSuccessPage.getPageHeading();
		String expected = "Your Account Has Been Created!";
		Assert.assertEquals(expected, actual);
	}

	@When("User selects yes for newsletter")
	public void user_selects_yes_for_newsletter() {

		registerAccountPage.selectYesNewsLetter();
		
		//driver.findElement(By.name("newsletter")).click();
	}

	@Then("User should get a proper warning message about duplicate email")
	public void user_should_get_a_proper_warning_message_about_duplicate_email() {

		String warning_msg = registerAccountPage.getWarningMsg();
		Assert.assertTrue(warning_msg.contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {

		registerAccountPage.enterFirstName("");
		registerAccountPage.enterLastName("");
		registerAccountPage.enterEmail("");
		registerAccountPage.enterTelephone("");
		registerAccountPage.enterPassword("");
		registerAccountPage.enterConfirmPassword("");	
		}

	@When("Clicks on continue button")
	public void clicks_on_continue_button() {

		registerAccountPage.clickOnContinueButton();
		
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("User should get proper warning messages for every mandatory fields")
	public void user_should_get_proper_warning_messages_for_every_mandatory_fields() {

		Assert.assertTrue(registerAccountPage.getWarningMsg().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerAccountPage.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerAccountPage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerAccountPage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerAccountPage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerAccountPage.getPasswordWarning());
	}

	

}
