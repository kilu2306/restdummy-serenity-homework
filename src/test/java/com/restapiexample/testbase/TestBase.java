package com.restapiexample.testbase;


import com.restapiexample.constant.path;
import com.restapiexample.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = path.employee;
    }
}