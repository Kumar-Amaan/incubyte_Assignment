package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import testComponents.BaseTest;

public class AccountSteps extends BaseTest{
    private HomePage homePage;
    private CreateAccountPage createAccountPage;
    private SignInPage signInPage;
    private String password = "Qwerty0123@";
    private static String email;

    @Given("I am on the Magento home page")
    public void i_am_on_the_magento_home_page() throws IOException {
    	homePage = launchApplication();
    }

    @When("I click on {string}")
    public void i_click_on(String linkText) {
        if (linkText.equals("Create an Account")) {
            homePage.clickCreateAccount();
            createAccountPage = new CreateAccountPage(driver);
        } else if (linkText.equals("Sign In")) {
            homePage.clickSignIn();
            signInPage = new SignInPage(driver);
        }
    }

    @When("I fill in the account creation form with valid details")
    public void i_fill_in_the_account_creation_form_with_valid_details() {
        email = "testuser" + System.currentTimeMillis() + "@xyz.com";
        createAccountPage.fillAccountForm("Test", "User", email, password);
    }

    @Then("I should see a success message for account creation")
    public void i_should_see_a_success_message_for_account_creation() throws InterruptedException {
        assertTrue(createAccountPage.isSuccessMessageDisplayed());
    }

    @When("I enter the newly created account credentials")
    public void i_enter_the_newly_created_account_credentials() {
        signInPage.signIn(email, password); 
    }

    @Then("I should be logged in and see the account dashboard")
    public void i_should_be_logged_in_and_see_the_account_dashboard() {
        assertTrue(signInPage.isLoggedIn());
    }
}
