package com.qa.FeedbackFormSubmit.util.exceptions;

public class FeedbackFormSubmitNotFoundException extends RuntimeException {

    public FeedbackFormSubmitNotFoundException(String exception){
        super("Id supplied does not exist. Id: " + exception);
    }
}
