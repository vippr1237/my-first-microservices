Feature: api testing

  Scenario: client make call to GET /
    When the client call /
    Then the client recieves status code of 200
    And the response should be "Demo Api for Devops Fresher"
