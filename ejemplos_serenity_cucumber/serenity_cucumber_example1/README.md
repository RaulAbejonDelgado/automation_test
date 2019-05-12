Cucumber background

es una herramienta para utilizar nuestros casos de pruebas en lenguaje legible para el ser humano

capa externa-> features usa gerking atiende al workflow cuando, dado, entonces objetemos

capa intermedia glue -> capa de pasos, union entre la capa externa con el codigo PageObject

capa selenium -> pageobjects



Feature: Search in dogpile Drohne – Wikipedia
  this feature will do multiple searchs and will return the text matching with the filter 2
  Scenario: should be see Expected results 2
    Given The user navigate to dogpile
    When The user does search in dogpile of hip hop: Drohne – Wikipedia
    Then should see expected text : Drohne (vom niederdeutschen drone, lautmalerisch zu ‚Dröhnen‘, aus indogermanisch dhren ‚brummen‘) steht für: Drohn, die männliche Honigbiene, Hummel ... text in result with title: Drohne – Wikipedia