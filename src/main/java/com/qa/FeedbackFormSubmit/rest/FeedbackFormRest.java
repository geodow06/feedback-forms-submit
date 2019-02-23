package com.qa.FeedbackFormSubmit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.FeedbackFormSubmit.persistence.domain.FeedbackForm;
import com.qa.FeedbackFormSubmit.persistence.domain.SentFeedbackForm;
import com.qa.FeedbackFormSubmit.service.FeedbackFormService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class FeedbackFormRest {

	@Autowired
	private FeedbackFormService service;
	    
    @Autowired
    private JmsTemplate jmsTemplate;
    
    
    @PostMapping("${path.addFeedbackForm}")
    public FeedbackForm addFeedbackForm(@RequestBody FeedbackForm feedbackForm) {
    	
    	SentFeedbackForm feedbackFormToSend = new SentFeedbackForm(feedbackForm);
    	sendToQueue(feedbackFormToSend);
    	return service.addFeedbackForm(feedbackForm);
    }
    
    private void sendToQueue(SentFeedbackForm formToStore){
        jmsTemplate.convertAndSend("FormQueue", formToStore);
    }
}

