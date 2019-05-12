Feature: Search in dogpile hip hop
  this feature will do multiple searchs and will return the text matching with the filter

  Scenario: should be see Expected results of hip hop
    Given The bot navigate to duckduckgo
    When The bot does search in duckduckgo of hip hop: hip hop
    Then The bot should see expected results containing: hip text

  Scenario: should be see Expected results of Drohne
    Given The bot navigate to duckduckgo
    When The bot does search in duckduckgo of hip hop: Drohne – Wikipedia
    Then should see expected text : Complete with Selfie Camera · #1 Rated Beginner's Drone · Anyone Can Fly in result with title: Drohne - Wiktionary


