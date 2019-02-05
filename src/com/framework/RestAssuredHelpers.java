package com.framework;


import io.restassured.RestAssured;

import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class RestAssuredHelpers {
    public static void main(String[] args) {

        RestAssured.get("https://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b1b15e88fa797225412429c1c50c122a1").then().statusCode(200);
    }
}
