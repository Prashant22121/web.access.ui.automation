Feature: Verify contact page error messages

  Scenario: Contact page mandatory error validations
    Given I launch the url
    When I navigate to contact page
    And I click on submit button
    Then I verify the error message
    And I enter the details