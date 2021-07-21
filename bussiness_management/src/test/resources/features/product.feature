Feature: Product Api

  Scenario: Create Product
    Given User set POST product service api endpoint
    When User Set request HEADER
    And User send a POST HTTP request
    Then User recieves status code of 201
    And User recieves valid POST response

  Scenario:Get Products
    When User send a GET HTTP request
    Then User recieves status code of 200
    And User recieves valid response

  Scenario:Update User
    When User Set request HEADER
    And User send a PUT HTTP request
    Then User recieves status code of 200
    And User recieves valid PUT response

  Scenario:Delete User
    Given User set DELETE product service api endpoint
    When User send a DELETE HTTP request
    Then User recieves status code of 200
    And User will recieves a message "Xóa thành công"
