package BlazeAction;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Blaze {
	private static final String BASE_URL = "https://demoblaze.com/";
	static RequestSpecification request = RestAssured.given().baseUri(BASE_URL);
	static ResponseBody body, bodyPhone, bodyLaptop, bodyMonitor, bodyNext, bodyLogin, bodyUser;
	static Response response, resPhone, resLaptop, resMonitor, resNext, resLogin, re, resUser;
	String token;
	JSONObject requestParams = new JSONObject();
	JSONObject requestparam = new JSONObject();
	JSONObject requestPar = new JSONObject();
	JSONObject reqparam = new JSONObject();
	JSONObject reparam = new JSONObject();

	private static final String base_path = "https://api.demoblaze.com/";
	static RequestSpecification httprequest = RestAssured.given().baseUri(base_path);

	// private static final String username = "abc786@gmail.com";
	// private static final String password = "QXV0b21hdGlvbkBUZXN0aW5nQDEyMw==";

	@Test
	public static void launchTheUrl() {
		response = request.when().get("/").then().statusCode(200).extract().response();
	}

	@Test
	public String getTitle() {
		body = response.getBody();
		return body.asString();

	}

	@Test
	public void loginPage() {
		JSONObject requestParams = new JSONObject();
		requestParams.put("username", "abc786@gmail.com");
		requestParams.put("password", "QXV0b21hdGlvbkBUZXN0aW5nQDEyMw==");
		resLogin = request.header("Content-Type", "application/json").body(requestParams.toString()).post("/login")
				.then().extract().response();

	}

	@Test
	public String getUser() {
		bodyLogin = resLogin.getBody();
		//System.out.println("token----------" + bodyLogin.asString());
		String token = bodyLogin.asString();
		token = token.replace("\"", "").split(" ")[1].trim();
		//System.out.println("Token generated: " + token);
		JSONObject requestParam = new JSONObject();
		requestParam.put("token", token);
		// System.out.println(requestParam.toString());
		resUser = request.header("Content-Type", "application/json").body(requestParam.toString()).post("/check").then()
				.statusCode(200).log().all().extract().response();
		bodyUser = resUser.getBody();
		//System.out.println("username: " + bodyUser.asString());
		return bodyUser.asString();
	}

	@Test
	public void callsPostRequesttogetphoneItem() {
		requestparam.put("cat", "phone");
		resPhone = httprequest.header("Content-Type", "application/json").body(requestparam.toString()).post("/bycat")
				.then().statusCode(200).extract().response().peek();

	}

	@Test
	public String getPhone() {
		bodyPhone = resPhone.getBody();
		return bodyPhone.asString();
	}

	@Test
	public void callsPostRequesttogetLaptopItem() {
		requestparam.put("cat", "notebook");
		resLaptop = httprequest.header("Content-Type", "application/json").body(requestparam.toString()).post("/bycat")
				.then().statusCode(200).extract().response().peek();

	}

	@Test
	public String getLaptops() {
		bodyLaptop = resLaptop.getBody();
		return bodyLaptop.asString();
	}

	@Test
	public void callsPostRequesttogetMonitorItem() {
		reqparam.put("cat", "monitor");
		resMonitor = httprequest.header("Content-Type", "application/json").body(reqparam.toString()).post("/bycat")
				.then().statusCode(200).extract().response().peek();

	}

	@Test
	public String getMonitors() {
		bodyMonitor = resMonitor.getBody();
		return bodyMonitor.asString();

	}

	@Test
	public void callsPostRequestToNavigateToNext() {
		reparam.put("id", "9");
		resNext = httprequest.header("Content-Type", "application/json").body(reparam.toString()).post("/pagination")
				.then().statusCode(200).extract().response().peek();

	}

	@Test
	public String nextPageItems() {
		bodyNext = resNext.getBody();
		return bodyNext.asString();

	}

}
