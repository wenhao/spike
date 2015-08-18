package org.github.wenhao.api;

import static org.glassfish.jersey.server.ServerProperties.BV_SEND_ERROR_IN_RESPONSE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyString;

import org.github.wenhao.model.User;
import org.github.wenhao.service.UserService;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.http.ContentType.JSON;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
public class UsersTest extends JerseySpringTest
{
    @Autowired
    private UserService userService;

    @Override
    protected ResourceConfig configure()
    {
        return new ResourceConfig(Users.class).property(BV_SEND_ERROR_IN_RESPONSE, true);
    }

    @Test
    public void should_be_able_to_get_single_user()
    {
        Mockito.when(userService.get(anyString())).thenReturn(new User("Eric", 50));

        given()
                .port(9998)
                .contentType(JSON)
                .pathParam("id", "101").
        when()
                .get("/users/{id}").
        then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("user.json"))
                .body("name", is("Eric"));

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
        given()
                .port(9998)
                .contentType(JSON)
                .accept(JSON)
                .body(new User("", 0)).
        when()
                .post("/users").
        then()
                .statusCode(400)
                .body("[0].message", equalTo("user's name shouldn't be empty."));
    }
}
