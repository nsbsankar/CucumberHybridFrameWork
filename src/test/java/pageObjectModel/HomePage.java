package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	
	public void clickOnMyAccount() {
		
		elementUtils.ClickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//myAccountDropMenu.click();
	}
	
	public LoginPage selectLoginOption() {
		
		elementUtils.ClickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterAccountPage selectRegisterOption() {
		
		elementUtils.ClickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//registerOption.click();
		return new RegisterAccountPage(driver);
	}
	
	public void enterProduct(String productText) {
		
		elementUtils.typeTextIntoElement(searchBoxField, productText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//searchBoxField.sendKeys(productText);
	}
	
	public SearchResultsPage clickOnSearchButton() {
		
		elementUtils.ClickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//searchButton.click();
		return new SearchResultsPage(driver);
	}
}
