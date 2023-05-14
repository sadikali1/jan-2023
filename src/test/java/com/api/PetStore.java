package com.api;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PetStore {
	
	private long id;
	
	@BeforeClass
	public void setupBase() {
		RestAssured.baseURI = "https://petstore.swagger.io";
	}
	
	@Test
	public void getPetsByStatus() {
		Response response = given().queryParam("status", "pending").when().get("/v2/pet/findByStatus");
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.asPrettyString());
	}
	
	@Test
	public void addPet() {
		String jsonData = "{"
				+ "  \"id\": 0,"
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"Cat\""
				+ "  },"
				+ "  \"name\": \"doggie\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"Tag1\""
				+ "    },"
				+"{"
						+ "      \"id\": 0,"
						+ "      \"name\": \"Tag2\""
						+ "    }"
				+ "  ],"
				+ "  \"status\": \"available\""
				+ "}";
		Response response = given().body(jsonData).header("accept", "application/json")
				.header("Content-Type", "application/json").when().post("/v2/pet");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getContentType(), "application/json");
		this.id = response.path("id");
		System.out.println(id);
		
		response.then().statusCode(200).contentType("application/json");
		response.then().body("status",  Matchers.equalTo("available")).body("category.name",  Matchers.equalTo("Cat"))
				.and().body("tags[0].name",  Matchers.equalTo("Tag1")).and().body("tags[1].name",  Matchers.equalTo("Tag2"));
		
	}
	
	@Test(dependsOnMethods = {"addPet"})
	public void updatePet() {
		String jsonData = "{"
				+ "  \"id\":"+this.id +","
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"string\""
				+ "  },"
				+ "  \"name\": \"doggie\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"string\""
				+ "    }"
				+ "  ],"
				+ "  \"status\": \"available\""
				+ "}";
		Response response = given().body(jsonData).header("accept", "application/json")
				.header("Content-Type", "application/json").put("/v2/pet");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getContentType(), "application/json");
	}

	@Test(dependsOnMethods = {"addPet", "updatePet"})
	public void getPetById() {
		Response response = given().header("accept", "application/json").get("/v2/pet/"+this.id );
				
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getContentType(), "application/json");
	}
	
	@Test(dependsOnMethods = {"getPetById"})
	public void deletePetById() {
		Response response = given().header("accept", "application/json").delete("/v2/pet/"+this.id );
				
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getContentType(), "application/json");
	}

}
