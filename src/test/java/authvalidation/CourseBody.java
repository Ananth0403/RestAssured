package authvalidation;

import org.testng.annotations.DataProvider;

public class CourseBody {
	
	@DataProvider(name="coursebody")
	public Object dataProvider() {
		return new Object[][] {{"client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com"},
								{"client_secret", "erZOWM9g3UtwNRj340YYaK_W"},
								{"grant_type", "client_credentials"},
								{"scope","trust"}};
	}

}
