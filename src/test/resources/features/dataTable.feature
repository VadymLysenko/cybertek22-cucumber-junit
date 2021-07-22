Feature: Examples of Cucumber data table implementation


  Scenario: Something happens
    #Given user does something
    Then user should see below words displayed
      | Apple      |
      | Kiwi       |
      | Orange     |
      | Strawberry |
      | Mango      |
      | Tomato     |
      | Cucumber   |

    # to fix pipes order
    #Mac command + option + L
    #Windows control + alt + L

  @wip
  Scenario: Library login example using data table
    Given user is on thr login page of library app
    When user enters username and password as below
      | username | librarian13@library.com |
      | password | 9rf6axdD                |
    Then user should see title is something