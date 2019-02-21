package com.qa.FeedbackFormSubmit.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
import com.qa.FeedbackFormSubmit.util.exceptions.FeedbackFormSubmitNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackFormServiceTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@InjectMocks
	FeedbackFormServiceImpl service;
	
	@Mock
	FeedbackFormRepository repo;
	
	private static final FeedbackForm MOCK_FEEDBACKFORM_1 = new FeedbackForm(1L, 2L, 2, 9, "yes", "maybe", "excellent", "no");
	private static final FeedbackForm MOCK_FEEDBACKFORM_2 = new FeedbackForm(2L, 3L, 5, 7, "no", "of course", "very good", "yes");
	private static final FeedbackForm MOCK_FEEDBACKFORM_3 = new FeedbackForm(3L, 3L, 8, 6, "Can do", "maybe", "excellent", "no");
	private static final FeedbackForm MOCK_FEEDBACKFORM_4 = new FeedbackForm(4L, 4L, 10, 4, "of course", "maybe", "bad", "no");

	private static final Optional<FeedbackForm> MOCK_ACCOUNT_OPTIONAL = Optional.of(MOCK_FEEDBACKFORM_1);
	private static final Optional<FeedbackForm> MOCK_NULL_OPTIONAL = Optional.empty();
	
	@Test
	public void getFeedbackFormByID() {
		Mockito.when(repo.findById(1L)).thenReturn(MOCK_ACCOUNT_OPTIONAL);
		Mockito.when(repo.findById(3L)).thenReturn(MOCK_NULL_OPTIONAL);
		assertEquals(service.getFeedbackFormByID(1L), MOCK_FEEDBACKFORM_1);
		
		exception.expect(FeedbackFormSubmitNotFoundException.class);
		service.getFeedbackFormByID(3L);
		
		Mockito.verify(repo).findById(1L);
	}
	
	@Test
	public void addFeedbackForm() {
		Mockito.when(repo.save(MOCK_FEEDBACKFORM_2)).thenReturn(MOCK_FEEDBACKFORM_2);
		assertEquals(MOCK_FEEDBACKFORM_2, service.addFeedbackForm(MOCK_FEEDBACKFORM_2));
		Mockito.verify(repo).save(MOCK_FEEDBACKFORM_2);
	}
	
	@Test
	public void getAllFeedbackForms() {
		List<FeedbackForm> MOCK_LIST = new ArrayList<>();;
		MOCK_LIST.add(MOCK_FEEDBACKFORM_1);
		MOCK_LIST.add(MOCK_FEEDBACKFORM_2);
		Mockito.when(repo.findAll()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getAllFeedbackForms());
		Mockito.verify(repo).findAll();
	}
	
	@Test
	public void getFeedbackFormsByUserID() {
		List<FeedbackForm> MOCK_LIST = new ArrayList<>();
		List<FeedbackForm> REAL_MOCK_LIST = new ArrayList<>();
		REAL_MOCK_LIST.add(MOCK_FEEDBACKFORM_2);
		REAL_MOCK_LIST.add(MOCK_FEEDBACKFORM_3);
		
		MOCK_LIST.add(MOCK_FEEDBACKFORM_1);
		MOCK_LIST.add(MOCK_FEEDBACKFORM_2);
		MOCK_LIST.add(MOCK_FEEDBACKFORM_3);
		MOCK_LIST.add(MOCK_FEEDBACKFORM_4);

		Mockito.when(repo.findAllByUserID(2L)).thenReturn(REAL_MOCK_LIST);
		assertEquals(REAL_MOCK_LIST, service.getFeedbackFormsByUserID(2L));
		Mockito.verify(repo).findAllByUserID(2L);
	}
}