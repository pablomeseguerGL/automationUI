@regression
Feature: space
  Background:Login
    Given Open Android platform
    And I click the "alreadyHaveAccountButton~Login" element
    And I enter "glooaccount2017" in the "loginUserNameTextBox~Login" field
    And I enter "gorilla" in the "loginPassWordTextBox~Login" field
    And I click the "loginButton~Login" element



  Scenario:New
    And I click the "createSpace" element
    And I click the "createSpace" element
    #And I "will" see the "messages" element
    And I "will" see the "actionCreateSpace" element
    And I click the "actionCreateSpace" element
    And I click the "actionCreateSpace" element
    And I click the "newSpaceOption" element
    And I enter "gorillaSpace" in the "newSpaceName" field
    And I close the keyboard
    And I click the "createButton" element





