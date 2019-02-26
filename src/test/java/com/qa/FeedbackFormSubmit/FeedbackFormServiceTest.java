package com.qa.FeedbackFormSubmit;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.FeedbackFormSubmit.persistence.domain.FeedbackForm;
import com.qa.FeedbackFormSubmit.persistence.repository.FeedbackFormRepository;
import com.qa.FeedbackFormSubmit.service.FeedbackFormServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackFormServiceTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@InjectMocks
	private FeedbackFormServiceImpl service;

	@Mock
	private FeedbackFormRepository repo;

	private static final FeedbackForm MOCK_FEEDBACK_FORM_1 = new FeedbackForm(123L, 456L, 8, 2, "There are", "too many", "questions in", "this form");

	@Test
	public void addFeedbackFormTest() {
		Mockito.when(repo.save(MOCK_FEEDBACK_FORM_1)).thenReturn(MOCK_FEEDBACK_FORM_1);
		assertEquals(MOCK_FEEDBACK_FORM_1, service.addFeedbackForm(MOCK_FEEDBACK_FORM_1));
		Mockito.verify(repo).save(MOCK_FEEDBACK_FORM_1);
	}
}
