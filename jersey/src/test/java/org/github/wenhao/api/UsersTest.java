package org.github.wenhao.api;

import javax.ws.rs.core.Application;

import static org.glassfish.jersey.server.ServerProperties.BV_SEND_ERROR_IN_RESPONSE;
import static org.hamcrest.CoreMatchers.is;

import org.github.wenhao.model.User;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;

public class UsersTest extends JerseyTest
{
    @Override
    protected Application configure()
    {
        return new ResourceConfig(Users.class).property(BV_SEND_ERROR_IN_RESPONSE, true);
    }

    @Test
    public void should_be_able_to_get_single_user()
    {
        given()
                .port(9998)
                .contentType(JSON)
                .pathParam("id", "101").
        when()
                .get("/users/{id}").
        then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("user.json"))
                .body("name", is("jack"));

    }

    @Test
    public void should_be_able_to_create_user()
    {
        given()
                .port(9998)
                .contentType(JSON)
                .body(new User("Eric", 29)).
        when()
                .post("/users").
        then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("user.json"))
                .body("name", is("Eric"));
    }

    @Test
    public void should_raise_error_if_user_name_is_empty_when_create_user()
    {
        RestAssured.registerParser("application/json", Parser.JSON);

        given()
                .port(9998)
                .contentType(JSON)
                .body(new User("", 0)).
        when()
                .post("/users").
        then()
                .statusCode(400);
    }
}
