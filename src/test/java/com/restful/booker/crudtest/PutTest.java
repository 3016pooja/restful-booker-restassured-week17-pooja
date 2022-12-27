package com.restful.booker.crudtest;

import com.restful.booker.model.PostsPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PutTest {
    @Test
    public void putBooking(){
        List<String> Bookingdate=new ArrayList<>();
        Bookingdate.add("2018-01-16");
        Bookingdate.add("2019-01-16");
        RestAssured.basePath = "/booking";
        PostsPojo postsPojo=new PostsPojo();
        postsPojo.setFirstName("prime");
        postsPojo.setLastName("testing");
        postsPojo.setTotalPrice("112");
        postsPojo.setDepositpaid("true");
        postsPojo.getBookingdates(Bookingdate);
        postsPojo.setAdditionalneeds("Dinner");
        Response response = given().log().all()
                .header("content-Type", "application/json")
                .when()
                .body(postsPojo)
                .put();
        response.prettyPrint();
        response.then().log().all().statusCode(200);

    }

}
