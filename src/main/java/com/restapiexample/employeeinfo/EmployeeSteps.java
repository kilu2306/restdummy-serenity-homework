package com.restapiexample.employeeinfo;

import com.restapiexample.constant.EndPoints;
import com.restapiexample.model.EmployeePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class EmployeeSteps {
    @Step("creat employee : by name : {0}, salary : {1} ,age : {2}, id {3}")
    public ValidatableResponse creatEmployee(String name,String salary,String age,int id){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName(name);
        employeePojo.setSalary(salary);
        employeePojo.setAge(age);
        employeePojo.setId(id);
       return SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .body(employeePojo)
                .when()
                .post(EndPoints.CREAT_EMPLOYEE)
               .then();

    }
    @Step ("get single employee by id : {3}")
    public ValidatableResponse getSingleEmployee(int id){
        return SerenityRest.given().log().all()
                .pathParam("employeeId",id)
                .when()
                .get(EndPoints.GET_SINGLE_EMPLOYEE_BY_ID)
                .then();
    }
    @Step
    public ValidatableResponse updateEmployee(int id ,String employee_name,int employee_salary,int employee_age,String profile_image){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setId(id);
        employeePojo.setEmployee_name(employee_name);
        employeePojo.setEmployee_salary(employee_salary);
        employeePojo.setEmployee_age(employee_age);
        employeePojo.setProfile_image(profile_image);

        return SerenityRest.given()
                .pathParam("employeeId",id)
                .contentType(ContentType.JSON)
                .when()
                .put(EndPoints.UPDATE_EMPLOYEE_BY_ID)
                .then();
    }
    @Step (" delet employee ")
    public ValidatableResponse deletSingleEmployee(int id){
        return SerenityRest.given().log().all()
                .pathParam("employeeId",id)
                .when()
                .delete(EndPoints.DELETE_EMPLOYEE_BY_ID)
                .then();
    }

}
