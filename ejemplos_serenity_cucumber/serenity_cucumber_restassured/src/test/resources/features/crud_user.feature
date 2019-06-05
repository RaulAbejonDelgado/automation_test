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

  Scenario Outline: DELETE user
    Given I will delete a user sending delete action by id <id>
    When after i will check the http response
    Then the response status should be 200

    Examples:
      | id |
      | 6   |

  Scenario Outline: PUT user
    Given i will update a user by id <id> with name <username> and password <password>
    When  after i send update action i will process the response
    Then the response status should be 200

    Examples:
      | id | username | password |
      | 4        | admin    | admin3    |
