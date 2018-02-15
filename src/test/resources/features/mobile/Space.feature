Feature: space

  Background:User is Logged In Android
    Given Open Android platform
    And I click the "alreadyHaveAccountButton~Login" element
    And I enter "glooaccount2017" in the "loginUserNameTextBox~Login" field
    And I enter "gorilla" in the "loginPassWordTextBox~Login" field
    And I click the "loginButton~Login" element
   # And I "will" see the "homeText~Login" element


  Scenario: :Create a new space

    And I click the "createSpace" element
    And I click the "messages" element
    #And I "will" see the "newSpaceOption" element
    #And I click the "createSpace" element
  #  And I click the "agreeSection" element
   # And I click the "actionCreateSpace" element
   # And I "will" see the "newSpaceOption" element
   # And I click the "newSpaceOption" element
    # And I click the "newSpaceOption" element
    #And I enter "gorillaSpace" in the "newSpaceName" field




