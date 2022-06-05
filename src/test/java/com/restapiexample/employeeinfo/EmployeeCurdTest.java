package com.restapiexample.employeeinfo;

import com.restapiexample.testbase.TestBase;
import com.restapiexample.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class EmployeeCurdTest extends TestBase {
    static String name = "kiya" + TestUtils.getRandomValue();
    static String salary = "2000";
    static String age = "23";
    static int id = 25;
    static String image="string";
    static int employeeSalary = 10000;
    static  int emplpyeeAge=40;
    static int employeeId;


    @Steps
    EmployeeSteps employeeSteps;

    @Title("creating  new employee record ")
    @Test
    public void test001() {
        ValidatableResponse response = employeeSteps.creatEmployee(name, salary, age, id);
        response.log().all().statusCode(200);

        employeeId= response.extract().path("data.id");
        System.out.println(employeeId);


    }
    @Title("getting single employee record ")
    @Test
    public void test002(){
        ValidatableResponse response =employeeSteps.getSingleEmployee(employeeId);
        response.log().all().statusCode(200);
        response.body("name",equalTo(name));

    }
    @Title("update employee record")
    @Test
    public void test003(){
        ValidatableResponse response= employeeSteps.updateEmployee(employeeId,name,employeeSalary,emplpyeeAge,image);
        response.log().all().statusCode(200);

    }
    @Title("delete employee record")
    @Test
    public void test004(){
        ValidatableResponse response =employeeSteps.deletSingleEmployee(employeeId);
        response.log().all().statusCode(200);

        ValidatableResponse response1 =employeeSteps.getSingleEmployee(employeeId);
        response1.log().all().statusCode(404);


    }
}
