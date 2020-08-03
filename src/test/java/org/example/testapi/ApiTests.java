package org.example.testapi;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class ApiTests {

    @Test
    void contextLoads() {
    }

    private String urllocal = "http://ec2-34-217-138-53.us-west-2.compute.amazonaws.com:8089";

    @Test
	public void postUserTestLocal(){
		given().
                queryParam("first", "Marcelo Josué").
                queryParam("last", "Telles add").
				when().
				post(urllocal+"/add").
				then().
				body(containsString("Added new customer to repo!"));
	}

    @Test
    public void postUserTestLocal2(){
        given().
                queryParam("first", "Marcelo Josué ").
                queryParam("last", "Telles add201").
                when().
                post(urllocal+"/add201").
                then().
                statusCode(200).
                body(containsString("CREATED"));
    }

    @Test
    public void putUserTest(){
        given().
                queryParam("id", "50 ").
                queryParam("first", "MARCELO JOSUÉ ").
                queryParam("last", "TELLES update").
                when().
                put(urllocal + "/update").
                then().
                statusCode(200).
                body(containsString("update customer"));
    }

    @Test
    public void putUserTest200(){
        given().
                queryParam("id", "49").
                queryParam("first", "MARCELO JOSUÉ ").
                queryParam("last", "TELLES update200 ").
                when().
                put(urllocal + "/update200").
                then().
                statusCode(200).
                body(containsString("CREATED"));
    }

    @Test
    public void deleteUserTest(){
        given().
                queryParam("id", "45").
                when().
                delete(urllocal + "/delete").
                then().
                statusCode(200).
                body(containsString("delete customer"));
    }

    @Test
    public void deleteUserTest204(){
        given().
                queryParam("id", "48").
                when().
                delete(urllocal + "/delete204").
                then().
                statusCode(204);
    }

}
