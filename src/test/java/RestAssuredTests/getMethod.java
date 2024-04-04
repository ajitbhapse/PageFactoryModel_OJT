package RestAssuredTests;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class getMethod {
	
	
	@Test
	public void testGetMethod() {
		Response resp = RestAssured.given()
				   .when()
				   .get("https://jsonplaceholder.typicode.com/posts/1");
		System.out.println("Body "+resp.body().asPrettyString());
		System.out.println("Status code "+resp.statusCode());
		System.out.println("Date "+resp.header("Date"));
	}

	@Test
	public void testPostMethod() {
		Response resp = RestAssured.given()
				   .header("Content-type","application/json")
				   .header("charset","UTF-8")
				   .body("{\r\n"
				   		+ "    \"title\": \"This is for testing the api manually\",\r\n"
				   		+ "    \"body\": \"we are learning api's\",\r\n"
				   		+ "    \"userId\": \"1\"\r\n"
				   		+ "}")
				   .when()
				   .post("https://jsonplaceholder.typicode.com/posts");
		System.out.println("Body "+resp.body().asPrettyString());
		System.out.println("Status code "+resp.statusCode());
		System.out.println("Date "+resp.header("Date"));
	}
	
	
	@Test
	public void testPutMethod() {
		Response resp = RestAssured.given()
				   .header("Content-type","application/json")
				   .header("charset","UTF-8")
				   .body("{\r\n"
				   		+ "    \"id\": \"1\",\r\n"
				   		+ "    \"title\": \"This is for testing\",\r\n"
				   		+ "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\",\r\n"
				   		+ "    \"userId\": \"1\"\r\n"
				   		+ "  }")
				   .when()
				   .put("https://jsonplaceholder.typicode.com/posts/1");
		System.out.println("Body "+resp.body().asPrettyString());
		System.out.println("Status code "+resp.statusCode());
		System.out.println("Date "+resp.header("Date"));
		Headers headers = resp.headers();
		List<Header> header = headers.asList();
		for(Header head :header) {
			System.out.println(head.getName() +":"+ head.getValue());
		}
	}
	@Test
	public void queryParam() {
		Response resp = RestAssured.given()
				    .params("userId","10")
				    .when()
				    .get("https://jsonplaceholder.typicode.com/posts");
		System.out.println("Body "+resp.body().asPrettyString());
		System.out.println("Status code "+resp.statusCode());
		System.out.println("Date "+resp.header("Date"));
	}
}
