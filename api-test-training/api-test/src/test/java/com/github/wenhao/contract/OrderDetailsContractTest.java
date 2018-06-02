package com.github.wenhao.contract;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class OrderDetailsContractTest {

    @Test
    public void verify_schema_of_order_details() {
        when().
             get("/orders/1").
        then().
             assertThat().body(matchesJsonSchemaInClasspath("orders/order-details.json"));
    }

}