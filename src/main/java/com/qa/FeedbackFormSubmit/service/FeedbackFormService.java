package com.qa.FeedbackFormSubmit.service;

import java.util.Collection;
import java.util.List;

import com.qa.FeedbackFormSubmit.persistence.domain.FeedbackForm;

public interface FeedbackFormService {

	Collection<FeedbackForm> getFeedbackFormsByUserID(Long userID);
	
	FeedbackForm getFeedbackFormByID(Long feedbackID);
	
	FeedbackForm addFeedbackForm(FeedbackForm feedbackForm);
	
	List<FeedbackForm> getAllFeedbackForms();
	
}
