@regression
  Feature: Test1

    Background : User is Logged In
      Given Open Android platform
      When I submit username
      When I submit password


    Scenario: Testing
      When I go to X page
      Then I see that element