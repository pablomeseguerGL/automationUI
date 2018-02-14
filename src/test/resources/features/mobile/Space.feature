Feature: Space
  Description: The purpose of this feature is to test the auth per platform
  Background:User is Logged In Android
    Given Open Android platform
    And I click the "alreadyHaveAccountButton" element
    And I enter "glooaccount2017" in the "loginUserNameTextBox" field
    And I enter "gorilla" in the "loginPassWordTextBox" field
    And I click the "loginButton" element
    And I "will" see the "homeText" element
    And I click the "homeText" element



  Scenario: Open Message scenario
    And I click the "createSpace" element


  Scenario: Open Message scenario
    And I click the "library" element



