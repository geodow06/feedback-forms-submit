package com.qa.FeedbackFormSubmit.rest;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import com.qa.FeedbackFormSubmit.FeedbackFormSubmitApplicationTests;

public class FeedbackFormRestTest extends FeedbackFormSubmitApplicationTests{

//	String base_path ="http://localhost:8085/feedbackForm";
//	String getAccounts="/getAccounts";
//	String postAccount= "/createAccount"; 
//	String getAccount = "/getAccountById/";
//	String updateAccount = "/updateAccount/";
//	String deleteAccount= "/deleteAccount/";
//	
//	String getAllFeedbackForms = "/getAllFeedbackForms";
//	
//    @Test
//    public void basicPingTest() {
//        given().when().get(base_path + getAllFeedbackForms).then().statusCode(200);
//    }
    
    @Test
    public void pingTest() {
    	given().when().get("/getAllFeedbackForms").then().statusCode(200);
    }
}
