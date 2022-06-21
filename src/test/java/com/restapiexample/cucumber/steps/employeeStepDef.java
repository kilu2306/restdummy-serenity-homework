package com.restapiexample.cucumber.steps;

import com.restapiexample.model.employeeinfo.EmployeeSteps;
import com.restapiexample.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class employeeStepDef {
    static String name = "kiya" + TestUtils.getRandomValue();
    static String salary = "2000";
    static String age = "23";
    static int id = 25;
    static String image="string";
    static int employeeSalary = 10000;
    static  int emplpyeeAge=40;
    static int employeeId;
    ValidatableResponse response;

    @Steps
    EmployeeSteps employeeSteps;

    @When("^I send post request for creating emoloyee$")
    public void iSendPostRequestForCreatingEmoloyee() {
    }

    @And("^I insert name, salary, age, id$")
    public void iInsertNameSalaryAgeId() {
        response= employeeSteps.creatEmployee(name, salary, age, id);

    }

    @Then("^User should be able to get succefull response for creating data$")
    public void userShouldBeAbleToGetSuccefullResponseForCreatingData() {
        response.statusCode(200);
    }

    @And("^User should be able to get Id for creating new employee$")
    public void userShouldBeAbleToGetIdForCreatingNewEmployee() {
        employeeId= response.extract().path("data.id");
    }

    @When("^I send get request to fatch single employee record by id$")
    public void iSendGetRequestToFatchSingleEmployeeRecordById() {
        response=employeeSteps.getSingleEmployee(employeeId);
    }

    @Then("^I should be able to get sucessfully employee record$")
    public void iShouldBeAbleToGetSucessfullyEmployeeRecord() {
        response.statusCode(200);
        response.body("name",equalTo(name));
    }

    @When("^I send patch request for updating employee$")
    public void iSendPatchRequestForUpdatingEmployee() {
        response=employeeSteps.updateEmployee(employeeId,name,employeeSalary,emplpyeeAge,image);
    }

    @And("^I update employeeId,name,employeeSalary,emplpyeeAge,image")
    public void iUpdateNameSalaryAgeId() {

    }

    @Then("^I should be able to update successfully$")
    public void iShouldBeAbleToUpdateSuccessfully() {
        response.statusCode(200);
    }

    @When("^I send delete request for deleting id$")
    public void iSendDeleteRequestForDeletingId() {
        response=employeeSteps.deletSingleEmployee(employeeId);
    }

    @Then("^I should be able to delete Employee succesfully$")
    public void iShouldBeAbleToDeleteEmployeeSuccesfully() {
        response.statusCode(204);
    }

    @And("^verify emoloyee has been deleted successfully$")
    public void verifyEmoloyeeHasBeenDeletedSuccessfully() {
        response=employeeSteps.getSingleEmployee(employeeId);
        response.statusCode(404);
    }
}
