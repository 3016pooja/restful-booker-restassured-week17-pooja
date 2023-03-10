package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ProductsAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://gorest.co.in/public/v2";

        response= given()
                .when()
                .get("/posts?page=1&per_page=25")
                .then().statusCode(200);

    }
//1.	Verify the if the total record  is  25
@Test
public void test001(){

    response.body("record",equalTo(25));
}
            //2.	Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto centum.”
            @Test
            public void test002(){
                response.body("[2].title",equalTo("Ad ipsa coruscus ipsam eos demitto centum."));
            }
	//3.Check the single user_id in the Array list (5522)
    @Test
    public void test003(){
        response.body("[4].user_id",equalTo(5522));
    }
            //4.	Check the multiple ids in the ArrayList (2693, 2684,2681)
           // @Test
//
               // response.body("id",hasItems(2737,2731,2730));
            //}
            @Test
            public void test004(){
                response.body("id",hasItems(2737,2731,2730));
            }
//5.verify body of userid=2678
@Test
public void test005(){
    response.body("[0].body",equalTo("Demitto tres sit. Catena ver triginta. Super viscus sponte. Cernuus sed tabernus."));
}
}
