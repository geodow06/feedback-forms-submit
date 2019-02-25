package com.qa.FeedbackFormSubmit.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.FeedbackFormSubmit.persistence.domain.FeedbackForm;
import com.qa.FeedbackFormSubmit.persistence.repository.FeedbackFormRepository;

@Service
public class FeedbackFormServiceImpl implements FeedbackFormService {

	@Autowired
	private FeedbackFormRepository repo;

	@Override
	public FeedbackForm addFeedbackForm(FeedbackForm feedbackForm) {
		return repo.save(feedbackForm);
	}

	
}
