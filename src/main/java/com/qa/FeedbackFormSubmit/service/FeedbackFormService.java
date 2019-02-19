package com.qa.FeedbackFormSubmit.service;

import java.util.List;

import com.qa.FeedbackFormSubmit.persistence.domain.FeedbackForm;

public interface FeedbackFormService {

	List<FeedbackForm> getAllUserFeedbackForms(Long userID);
	
	FeedbackForm getAFeedbackForm(Long feedbackID);
	
	FeedbackForm addFeedbackForm(FeedbackForm feedbackForm);
	
}
