Feature: Test of GitHub
  As a GitHub user
  I want to test the basic functionalities of the GitHub

  Background: 

  Scenario: Validate the GitHub search result
    Given I navigate to "https://github.com"
    And I search a text "hygieia"
    When I click on the search icon
    Then I see the search result
    And The number of repositories should be more than "3"
    
  Scenario: Validate the capitalone/Hygieia repository
    Given I navigate to "https://github.com"
    And I search a text "hygieia"
    When I click on the search icon
    Then I see the search result
    When I click on the Hygieia link
    Then I navigate to the Hygieia repository
    And The number of commits is more than "2000"
    And The number of branches is more than "4"
    And The number of release is more than or equal to "8"
    And The number of contributors is more than "50"
