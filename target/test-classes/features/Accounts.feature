Feature: Account Management on Magento Demo Store

  Scenario: Create a new account
    Given I am on the Magento home page
    When I click on "Create an Account"
    And I fill in the account creation form with valid details
    Then I should see a success message for account creation


  Scenario: Sign in with the newly created account
    Given I am on the Magento home page
    When I click on "Sign In"
    And I enter the newly created account credentials
    Then I should be logged in and see the account dashboard