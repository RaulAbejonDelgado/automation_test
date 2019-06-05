package com.raul.rest.cucumber.assure.steps;

import com.raul.rest.cucumber.assure.pojo.User;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserAPISteps {
	
    private Response res = null; //Response
    private JsonPath jp = null; //JsonPath
    private RequestSpecification requestSpec;
    private List<User> users = new ArrayList<>();
    private User user ;
    private String URL = "http://localhost:3000/user";
    private int status = 0;

    /*-----------Get-----------*/
    @Test
    @Step("doing get over api and check http request response")
    public void sendGetUsers() {

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBasePath("user");
        builder.setContentType("application/json");
        requestSpec = builder.build();
        requestSpec = RestAssured.given().spec(requestSpec);
        requestSpec.log().all();
        res = requestSpec.when().get(URL);

    }

    @Test
    @Step("Then i process the response and do assertions ")
    public void processResponse(){

        switch (res.getStatusCode()) {
            case 200 :
                users = res.getBody().jsonPath().getList("", User.class);
                Assert.assertEquals(200, res.getStatusCode());
                Assert.assertTrue(users.size() > 0);
                break;
        }

    }

    @Test
    @Step("validating data with expected users {0},{1},{2}")
    public void checkUser(String id, String name, String password) {

        Assert.assertTrue(users.get(Integer.parseInt(id)).getName().equals(name));
        Assert.assertTrue(users.get(Integer.parseInt(id)).getPassword().equals(password));

    }


    @Test
    @Step("i will create object and parse to json to post it")
    public void procesingData(String name, String password) {

            RequestSpecBuilder builder = new RequestSpecBuilder();
            builder.setBasePath("user");
            builder.setContentType("application/json");
            System.out.println("{\"name\":\""+name+"\",\"password\": \""+password+"\"}");
            builder.setBody("{\"name\":\""+name+"\",\"password\": \""+password+"\"}");
            requestSpec = builder.build();
            requestSpec = RestAssured.given().spec(requestSpec);
            requestSpec.log().all();
            user = new User(name,password);

    }

    @Test
    @Step("User object is ready, i will do post it")
    public void postUser() {

        res = requestSpec.when().post();
        System.out.println(res.getStatusCode());
        Assert.assertTrue(res.getStatusCode() == 201);

    }

    @Test
    @Step("if all ok i will verify data user : {0} password : {1}")
    public void verifyData(String name, String password) {
        User u = new User();
        user.setName(res.getBody().jsonPath().getString("name"));
        user.setPassword(res.getBody().jsonPath().getString("password"));

        Assert.assertTrue(name.equals(user.getName()) && password.equals(user.getPassword()));

    }

    @Test
    @Step("i will try delete the user with id -> {0}")
    public void deleteUserById(int id) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBasePath("user");
        builder.setContentType("application/json");
        requestSpec = builder.build();
        requestSpec = RestAssured.given().spec(requestSpec);
        res = requestSpec.when().delete(URL+"/"+id);

        System.out.println(res);
    }

    @Test
    @Step("im checking http response...")
    public void afterIWillCheckTheHttpResponse() {
        status = res.getStatusCode();

    }


    @Test
    @Step("i evaluate status code {0}")
    public void theResponseStatusShouldBeStatus(String status) {

        switch (res.getStatusCode()) {
            case 200 :
                Assert.assertTrue(res.getStatusCode() == Integer.parseInt(status));
        }
    }

    @Test
    @Step("preparing data to send")
    public void iWillUpdateAUserByIdId(int id, User u) {
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.setBasePath("user");
        builder.setContentType("application/json");
        builder.setBody("{\"name\": \""+u.getName()+"\",\n" +
                     "\"password\": \""+u.getPassword()+"\"}");

        requestSpec = builder.build();
        requestSpec = RestAssured.given().spec(requestSpec);
        res = requestSpec.when().put(URL+"/"+id);


    }

    @Test
    @Step("preparing data to send")
    public void afterISendUpdateActionIWillProcessTheResponse() {

        status = res.getStatusCode();

    }
}
