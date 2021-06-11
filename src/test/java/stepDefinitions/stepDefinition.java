package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import pojo.*;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefinition extends Utils{
	ResponseSpecification resspec;
	 RequestSpecification res;
	 Response response;
	 TestDataBuild data = new TestDataBuild();
	 @Given("Add Place payload with {string} {string} {string}")
	 public void add_place_payload_with(String name, String language, String address) throws IOException {
		
		
		
		 
		 res=given().spec(requestSpecification())	
		.body(data.AddplacePayload(name,language,address));
	}

	 @When("user calls {string} with {string}  http request")
	 public void user_calls_with_http_request(String resource, String method)  {
		 ApiResources resourceAPI= ApiResources.valueOf(resource);
		 System.out.println(resourceAPI.getResource());
		 
		 resspec=  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response=res.when().post(resourceAPI.getResource())
				.then().spec(resspec).extract().response();
		 
		 //chauhansaab maharaj
	}

	@Then("the api call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		Assert.assertEquals(response.getStatusCode(), 200);
		
	    
	}

	@And("{string} in response is {string}")
	public void in_response_is(String key, String expectedValue) {
	    String resp= response.asString();
	    JsonPath js= new JsonPath(resp);
	    Assert.assertEquals(js.get(key).toString(), expectedValue);
	}

	@And("{string} in response body is {string}")
	public void scope_in_response_body_is(String key, String expectedValue) {
	    String resp=response.asString();
	    JsonPath js= new JsonPath(resp);
	    Assert.assertEquals(js.get(key), expectedValue	);
	}

}
