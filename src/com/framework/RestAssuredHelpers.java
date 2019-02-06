package com.framework;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredHelpers {
	@Test
	public void openweathermap() {

		RestAssured.get(
				"https://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b1b15e88fa797225412429c1c50c122a1")
				.then().statusCode(200);

	}

	@Test
	public void echo_jsontest() {

		RestAssured.baseURI = "http://echo.jsontest.com";
		RequestSpecification rs = RestAssured.given();
		JSONObject jsonObject = new JSONObject();
		Response res = rs.get("Key1/value/Key2/two");
		System.out.println(res.getBody().asString().toString());
		System.out.println(res.getBody().jsonPath().getString("value").toString());
	}

	@Test
	public void ip_jsontest_POJO() {

		RestAssured.baseURI = "http://ip.jsontest.com";
		RequestSpecification rs = RestAssured.given();
		JSONObject jsonObject = new JSONObject();
		Response res = rs.get();
		System.out.println(res.getBody().asString().toString());
		Machine machine = res.getBody().as(Machine.class);
		System.out.println(machine.getIp());
		System.out.println(res.getBody().jsonPath().getString("ip").toString());
	}
}

final class Machine {

	private String ip1;

	public String getIp() {
		return ip1;
	}

	public void setIp(String ip) {
		this.ip1 = ip;
	}
}
