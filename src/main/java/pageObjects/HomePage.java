package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(linkText = "Create an Account")
    private WebElement createAccountLink;

    @FindBy(linkText = "Sign In")
    private WebElement signInLink;
    
    @FindBy(xpath = "(//li[@class='authorization-link']//a)[1]")
    private WebElement signOut;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateAccount() {
        createAccountLink.click();
    }

    public void clickSignIn() {
        signInLink.click();
    }
    public void goTo(String url)
	{
		driver.get(url);
	}
    
}