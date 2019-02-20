package com.qa.FeedbackFormSubmit.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.FeedbackFormSubmit.persistence.repository.FeedbackFormRepository;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackFormServiceTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@InjectMocks
	FeedbackFormServiceImpl service;
	
	@Mock
	FeedbackFormRepository repo;
	
	@Test
	public void getFeedbackFormsByUserID() {
		
	}
	
	@Test
	public void getFeedbackFormByID() {
		
	}
	
	@Test
	public void addFeedbackForm() {
		
	}
	
	@Test
	public void getAllFeedbackForms() {
		
	}
}