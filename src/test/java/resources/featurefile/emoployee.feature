Feature: End to end Testing for employee

  Scenario: I should be able to creat employee record successfully
    When I send post request for creating emoloyee
    And I insert name, salary, age, id
    Then User should be able to get succefull response for creating data
    And  User should be able to get Id for creating new employee

  Scenario: I should be able to get single record by id
    When I send get request to fatch single employee record by id
    Then I should be able to get sucessfully employee record

  Scenario: I should be able to update employee by id
    When I send patch request for updating employee
    And I update employeeId,name,employeeSalary,emplpyeeAge,image
    Then I should be able to update successfully

  Scenario: I should be able to delet employee by id
    When I send delete request for deleting id
    Then I should be able to delete Employee succesfully
    And  verify emoloyee has been deleted successfully
