package authvalidation;
import io.restassured.*;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import org.testng.annotations.*;


public class CourseDetails {

	@Test
	public static void getCourse() {
		String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope","trust")
		.when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").then().extract().response().asString();
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String at = js.getString("access_token");
		
		String response1 = given().formParam("access_token", ""+at+"").when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails?access_token="+at).then().extract().response().asString();
		System.out.println(response1);
//		
	}

}
