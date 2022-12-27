package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class UserAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://gorest.co.in/public/v2";

        response= given()
                .when()
                .get("/users?page=1&per_page=20")
                .then().statusCode(200);
    }

  //  1.	Verify the if the total record  is  20

    @Test
    public void verifyTheTotal(){

        response.body("id",equalTo(20));
    }
           // 2.	Verify the if the name of id = 5487 is equal to ”Hamsini Trivedi”
           @Test
           public void test002(){
                response.body("[0].name",equalTo("Rameshwar Varman"));
           }
          //  3.	Check the single ‘Name’ in the Array list (Subhashini Talwar)
          @Test
          public void test003(){
              response.body("[0].name",equalTo("Rameshwar Varman"));
          }
//4.	Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV)

    @Test
    public void test004(){

        response.body("name", hasItems("Bhilangana Shah", "Ganak Jain", "Aaryan Nayar"));

    }
//5.	Verify the emai of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
@Test
public void test005(){
    response.body("[0].email",equalTo("varman_rameshwar@johnston.info"));
}
          //  6.	Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void test006(){
       // response.body("[4].status",hasKey("active"));
        response.body("[4].status",equalTo("active"));
    }
           // 7.	Verify the Gender = male of user name is “Niro Prajapat”
           @Test
           public void test007(){
               response.body("[4].name",equalTo("Subodh Menon"));
           }
}