package com.restful.booker.crudtest;

import com.restful.booker.model.PostsPojo;
import com.restful.booker.model.UserPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostTest extends TestBase {
    @Test
    public void postRestFullBooker() {
        UserPojo userPojo = new UserPojo();
        userPojo.setUsername("admin");
        userPojo.setPassword("prime123");
        RestAssured.basePath = "/auth";
        Response response = given().log().all()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post();
        response.prettyPrint();
        response.then().log().all().statusCode(200);
    }

        @Test
        public void postBooking(){
            List<String>Bookingdate=new ArrayList<>();
            Bookingdate.add("2018-01-16");
            Bookingdate.add("2019-01-16");
            RestAssured.basePath = "/booking";
            PostsPojo postsPojo=new PostsPojo();
            postsPojo.setFirstName("prime");
            postsPojo.setLastName("testing");
            postsPojo.setTotalPrice("112");
            postsPojo.setDepositpaid("true");
            postsPojo.getBookingdates(Bookingdate);
            postsPojo.setAdditionalneeds("Lunch");
            Response response = given().log().all()
                    .header("content-Type", "application/json")
                    .when()
                    .body(postsPojo)
                    .post();
            response.prettyPrint();
            response.then().log().all().statusCode(200);

    }


}
