package com.qa.FeedbackFormSubmit.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.FeedbackFormSubmit.persistence.domain.FeedbackForm;
import com.qa.FeedbackFormSubmit.persistence.repository.FeedbackFormRepository;
import com.qa.FeedbackFormSubmit.util.exceptions.FeedbackFormSubmitNotFoundException;

@Service
public class FeedbackFormServiceImpl implements FeedbackFormService {

	@Autowired
	private FeedbackFormRepository repo;
	
	@Override
	public Collection<FeedbackForm> getAllUserFeedbackForms(Long userID) {
		List<FeedbackForm> feedbackFormList = repo.findAll();
		Collection<FeedbackForm> feedbackFormID = feedbackFormList.stream().filter(a -> a.getUserID().equals(userID)).collect(Collectors.toList());
		return feedbackFormID;
	}

	@Override
	public FeedbackForm getAFeedbackForm(Long feedbackID) {
		Optional<FeedbackForm> feedbackForm = repo.findById(feedbackID);
		return feedbackForm.orElseThrow(() -> new FeedbackFormSubmitNotFoundException(feedbackID.toString()));
	}

	@Override
	public FeedbackForm addFeedbackForm(FeedbackForm feedbackForm) {
		return repo.save(feedbackForm);
	}
	
    @Override
    public List<FeedbackForm> getAllFeedbackForms() {
        return repo.findAll();
    }

}
