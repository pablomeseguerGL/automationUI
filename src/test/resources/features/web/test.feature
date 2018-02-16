@regression
  Feature: getdemo

    Scenario: Testing
      Given Open Web platform
      When I go to "https://www.gloo.us/demo?hsCtaTracking=0c18f305-6472-4baa-b2ca-47db6636483d%7C237d9870-b5e2-4273-9cc8-ec9c5073117c" page
      And I enter "glooaccount2017" in the "glooDemo" field

