Feature: Search in duckduckgo hip hop
  this feature will do multiple searchs and will return the text matching with the filter

  Scenario: should be see Expected results of hip hop
    Given The bot navigate to duckduckgo
    When The bot does search in duckduckgo of hip hop: hip hop
    Then The bot should see expected results containing: hip text

  Scenario Outline: should be see Expected results of Drohne
    Given The bot navigate to duckduckgo
    When The bot does search in duckduckgo of hip hop: <title>
    Then should see expected text : <text> in result with title: <title>

    Examples:
    | desciption  | title                 |  text                                                                                                                                                               |
    | searched serenity | Serenity BDD · GitHub |  The BDD Trader application is a demo application used for exercises in the Serenity Dojo BDD workshops Java 12 15 Apache-2.0 Updated Dec 7, 2018 serenity-banking-demo                                                                     |
    | searched cucumber | Cucumber - Test Automation Wiki  | Gherkin is the language that Cucumber uses to define test cases. It is designed to be non-technical and human readable, and collectively describes use cases relating to a software system. [10] [11] [20] [21] The purpose behind Gherkin's syntax is to promote behavior-driven development practices across an entire development team, including ...   |


