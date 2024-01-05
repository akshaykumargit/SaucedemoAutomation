#For automating the Swag Labs website for interview purpose
@SmokeFeature
Feature: feature to test login functionality

	@smoketest
  Scenario: Check if user is able to add item to cart
    Given user is on login page
    When user enters username
    And click on login button
    Then user is navigated to home page 
    And user adds an item into cart
    And user clicks on checkout in cart
    And user enters delivery details
    And user completes the order successfully


