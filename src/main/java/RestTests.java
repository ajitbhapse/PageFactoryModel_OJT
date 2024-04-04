import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestTests {

	@Test
	public void getMethod() {

		Response resp =
				// GIVEN
				RestAssured.given()
				// WHEN
				.when().get("https://jsonplaceholder.typicode.com/posts/1");
				// THEN
				System.out.println(resp.body().asPrettyString());
				System.out.println(resp.statusCode());
				System.out.println(resp.header("Date"));
	}
	
	@Test
	public void postMethod() {
		
		Response resp =
		// GIVEN
		RestAssured.given()
					.header("Content-type","application/json")
					.header("charset","UTF-8")
					.body("{\r\n"
							+ "    \"title\": \"Learning API's\",\r\n"
							+ "    \"body\": \"Learning RestAssured and Postman\",\r\n"
							+ "    \"userId\": \"1\"\r\n"
							+ "  }")
					
		// WHEN
					.when().post("https://jsonplaceholder.typicode.com/posts");
		// THEN
					System.out.println(resp.body().asPrettyString());
					System.out.println(resp.statusCode());
					System.out.println(resp.header("Date"));

	}

}
