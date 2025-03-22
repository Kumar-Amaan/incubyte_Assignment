package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Helper;

public class SignInPage extends Helper{
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "send2")
    private WebElement signInButton;

    @FindBy(css = ".logged-in")
    private WebElement welcomeMessage;

    public SignInPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signIn(String email, String password) {
    	waitForWebElementToAppear(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }

    public boolean isLoggedIn() {
        return welcomeMessage.isDisplayed();
    }
}
