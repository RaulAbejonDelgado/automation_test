Feature: CRUD User

  This will check crud operations methods

  Scenario Outline: GET user
    Given Get users
    When i haves res i process data on User
    Then i do operations over res data <position> <username> <password>
    Examples:
      | position | username | password |
      | 0        | admin    | admin    |
      | 1        | drohne   | drohne   |

  Scenario Outline: POST user
    Given i want post the next object with this values <username> <password>
    When data is alright to do post
    Then i check http response and i verify the new data with the given data <username> <password>

    Examples:
      | username | password |
      | tester   | tester   |
