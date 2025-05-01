import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Addbook {
	
	//given- only inputs
	//when - submitting API with resource
	//Then - validate
	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().body("{\r\n"
				+ "\"name\":\"Learn Automation with python\",\r\n"
				+ "\"isbn\":\"AN82\",\r\n"
				+ "\"aisle\":\"9776\",\r\n"
				+ "\"author\":\"chandl\"\r\n"
				+ "}").when().post("/Library/Addbook.php").then().assertThat().statusCode(200).
				body("Msg", equalTo("Book Already Exists")).extract().response().asString();
		
		System.out.println(response);
		String response1 = given().log().all().queryParam("ID", "AN829776") .when().get("/Library/GetBook.php").then().log().all().assertThat().statusCode(200).extract().response().asString() ;
		System.out.println("sec:  "+response1);
		
//		given().log().all().body("{\r\n"
//				+ "\"name\":\"Learn Automation with Java\",\r\n"
//				+ "\"isbn\":\"AN82\",\r\n"
//				+ "\"aisle\":\"9776\",\r\n"
//				+ "\"author\":\"chandl\"\r\n"
//				+ "}").when().put("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).body("Msg", equalTo("Book Already Exists"));
		
	}

}
