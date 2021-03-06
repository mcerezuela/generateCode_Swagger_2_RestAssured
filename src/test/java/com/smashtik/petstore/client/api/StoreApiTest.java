/*
 * Swagger Petstore
 * This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.5
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.smashtik.petstore.client.api;

import com.smashtik.petstore.client.ApiClient;
import com.smashtik.petstore.client.api.test.utils.PetUtils;
import com.smashtik.petstore.client.api.test.utils.StoreUtils;
import com.smashtik.petstore.client.model.Order;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static com.smashtik.petstore.client.GsonObjectMapper.gson;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;

/**
 * API tests for StoreApi
 */
@Ignore
public class StoreApiTest {

    private StoreApi api;
    private PetApiTest petApiTest = new PetApiTest();

    @Before
    public void createApi() {
        api = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder().setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri("https://petstore.swagger.io/v2"))).store();
        petApiTest.createApi();
    }

    /**
     * Invalid ID supplied
     */
    @Test
    public void shouldSee400AfterDeleteOrder() {
        String orderId = "-1000L";
        api.deleteOrder()
                .orderIdPath(orderId).execute(r -> r.prettyPeek())
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    /**
     * Order not found
     */
    @Test
    public void shouldSee404AfterDeleteOrder() {
        Long orderId = -1000L;
        api.deleteOrder()
                .orderIdPath(orderId).execute(r -> r.prettyPeek())
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }


    /**
     * successful operation
     */
    @Test
    public void shouldSee200AfterGetInventory() {
        api.getInventory().execute(r -> r.prettyPeek())
                .then()
                .statusCode(HttpStatus.SC_OK);}


    /**
     * successful operation
     */
    @Test
    public void shouldSee200AfterGetOrderById() {
        Long orderId = placeRandomOrder().as(Order.class).getId();
        api.getOrderById()
                .orderIdPath(orderId).execute(r -> r.prettyPeek())
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    /**
     * Invalid ID supplied
     */
    @Test
    public void shouldSee400AfterGetOrderById() {
        String orderId = "-1000L";
        api.getOrderById()
                .orderIdPath(orderId).execute(r -> r.prettyPeek())
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    /**
     * Order not found
     */
    @Test
    public void shouldSee404AfterGetOrderById() {
        Long orderId = -1000L;
        api.getOrderById()
                .orderIdPath(orderId).execute(r -> r.prettyPeek())
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }


    /**
     * successful operation
     */
    @Test
    public void shouldSee200AfterPlaceOrder() {
        Response responseOrder = placeRandomOrder();
        responseOrder.then()
                .statusCode(HttpStatus.SC_OK);
        api.deleteOrder()
                .orderIdPath(responseOrder.as(Order.class).getId()).execute(r -> r.prettyPeek())
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    /**
     * Invalid Order
     */
    @Test
    public void shouldSee400AfterPlaceOrder() {
        Order body = StoreUtils.createRandomOrder();
        api.placeOrder()
                .body(body).execute(r -> r.prettyPeek())
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    private Response placeRandomOrder() {
        Order body = StoreUtils.createRandomOrder();
        return api.placeOrder()
                .body(body).execute(r -> r.prettyPeek());
    }

}