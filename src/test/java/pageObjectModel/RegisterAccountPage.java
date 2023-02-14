package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterAccountPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterAccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(name="newsletter")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMsg;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public void enterFirstName(String firstName) {
		
		elementUtils.typeTextIntoElement(firstNameField, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//firstNameField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastname) {
		
		elementUtils.typeTextIntoElement(lastNameField, lastname, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//lastNameField.sendKeys(lastname);
	}
	
	public void enterEmail(String email) {
		
		elementUtils.typeTextIntoElement(emailField, email, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//emailField.sendKeys(email);
	}
	
	public void enterTelephone(String telephone) {
		
		elementUtils.typeTextIntoElement(telephoneField, telephone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//telephoneField.sendKeys(telephone);
	}
	
	public void enterPassword(String password) {
		
		elementUtils.typeTextIntoElement(passwordField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//passwordField.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		
		elementUtils.typeTextIntoElement(confirmPasswordField, confirmPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//confirmPasswordField.sendKeys(confirmPassword);
	}
	
	public void clickOnPrivacyPolicy() {
		
		elementUtils.ClickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//privacyPolicyOption.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		
		elementUtils.ClickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsLetter() {
		
		elementUtils.ClickOnElement(yesNewsLetterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//yesNewsLetterOption.click();
	}
	
	public String getWarningMsg() {
		
		return elementUtils.getTextFromElement(warningMsg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return warningMsg.getText();
	}
	
	public String getFirstNameWarning() {
		
		return elementUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return firstNameWarning.getText();
	}
	
	public String getLastNameWarning() {
		
		return elementUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return lastNameWarning.getText();
	}
	
	public String getEmailWarning() {
		
		return elementUtils.getTextFromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	//	return emailWarning.getText();
	}
	
	public String getTelephoneWarning() {
		
		return elementUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return telephoneWarning.getText();
	}
	
	public String getPasswordWarning() {
		
		return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return passwordWarning.getText();
	}
}
