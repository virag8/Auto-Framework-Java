package com.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredHelpers {
	@Test
	@Ignore
	public void openweathermap() {

		RestAssured.get(
				"https://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b1b15e88fa797225412429c1c50c122a1")
				.then().statusCode(200);

	}

	@Test
	@Ignore
	public void echo_jsontest() {

		RestAssured.baseURI = "http://echo.jsontest.com";
		RequestSpecification rs = RestAssured.given();
		Response res = rs.get("Key1/value/Key2/two");
		System.out.println(res.getBody().asString().toString());
		System.out.println(res.getBody().jsonPath().getString("value").toString());
	}

	@Test
	@Ignore
	public void ip_jsontest_POJO() {

		RestAssured.baseURI = "http://ip.jsontest.com";
		RequestSpecification rs = RestAssured.given();
		Response res = rs.get();
		System.out.println(res.getBody().asString());
		Machine machine = res.getBody().as(Machine.class);
		System.out.println(machine.getIp());
		System.out.println(res.getBody().jsonPath().getString("ip").toString());
	}

	@Test
	@Ignore
	public void ip_jsonvalidate_POJO() throws IOException {

		RestAssured.baseURI = "http://validate.jsontest.com";
		RequestSpecification rs = RestAssured.given();
		rs.queryParam("json", "{\"key\":\"value\"}");
		Response res = rs.get();
		System.out.println(res.getBody().asString());
		Validate validate = res.getBody().as(Validate.class);
		// System.out.println(validate.isEmpty1());
		// System.out.println(res.getBody().jsonPath().getString("empty1"));

		File initialFile = new File("resources/schema.json");
		InputStream targetStream = new FileInputStream(initialFile);

		JSONObject jsonSchema = new JSONObject(new JSONTokener(targetStream));
		JSONObject jsonSubject = new JSONObject(new JSONTokener(res.getBody().asInputStream()));

		Schema schema = SchemaLoader.load(jsonSchema);
		schema.validate(jsonSubject);
	}

	@Test
	public void jsonplaceholder_typicode() throws IOException {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/photos";
		RequestSpecification rs = RestAssured.given();
		Response res = rs.get();
		// System.out.println(res.getBody().asString());
		List<Photos> photos = res.getBody().jsonPath().getList("", Photos.class);
		// List<Photos> photos1 = res.getBody().jsonPath().getObject("photos",
		// Photos[].class);
		for (Photos photos2 : photos) {

		}
		System.out.println(photos.size());
		System.out.println(res.getBody().jsonPath().getString("url"));

	}
}

class Photos {
	private int albumId;
	private int id;
	private String title;
	private String url;
	private String thumbnailUrl;

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
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

final class Validate {

	private int size;
	private long parse_time_nanoseconds;
	private String object_or_array;
	private boolean validate;
	private boolean empty;

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getParse_time_nanoseconds() {
		return parse_time_nanoseconds;
	}

	public void setParse_time_nanoseconds(long parse_time_nanoseconds) {
		this.parse_time_nanoseconds = parse_time_nanoseconds;
	}

	public String getObject_or_array() {
		return object_or_array;
	}

	public void setObject_or_array(String object_or_array) {
		this.object_or_array = object_or_array;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

}
