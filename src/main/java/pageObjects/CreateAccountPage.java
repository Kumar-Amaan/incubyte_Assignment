package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Helper;

public class CreateAccountPage extends Helper {
	WebDriver driver;

	@FindBy(id = "firstname")
	private WebElement firstNameField;

	@FindBy(id = "lastname")
	private WebElement lastNameField;

	@FindBy(id = "email_address")
	private WebElement emailField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "password-confirmation")
	private WebElement confirmPasswordField;

	@FindBy(css = "button[title='Create an Account']")
	private WebElement createAccountButton;

	@FindBy(xpath = "//div[contains(@data-bind, 'prepareMessageForHtml')]")
	private WebElement successMessage;
	private By successMessageLocator = By.xpath("//div[text()='Thank you for registering with Main Website Store.']");

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillAccountForm(String firstName, String lastName, String email, String password) {
		waitForWebElementToAppear(firstNameField);
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(password);
		createAccountButton.click();
	}

	public boolean isSuccessMessageDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		int attempts = 0;

		while (attempts < 3) {
			try {
				WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
				return message.isDisplayed();
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return false;
	}
}