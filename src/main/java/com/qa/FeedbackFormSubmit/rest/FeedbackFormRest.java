package com.qa.FeedbackFormSubmit.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("${path.getFeedbackFormsByUserID}")
    public Collection<FeedbackForm> getFeedbackFormsByUserID(@PathVariable Long userID){
    	return service.getFeedbackFormsByUserID(userID);
    }
    
    @GetMapping("${path.getFeedbackFormByID}")
    public FeedbackForm getFeedbackFormByID(@PathVariable Long feedbackID) {
    	return service.getFeedbackFormByID(feedbackID);
    }
    
    @PostMapping("${path.addFeedbackForm}")
    public FeedbackForm addFeedbackForm(@RequestBody FeedbackForm feedbackForm) {
    	sendToQueue(feedbackForm);
    	return service.addFeedbackForm(feedbackForm);
    }
    
    @GetMapping("${path.getAllFeedbackForms}")
    public Collection<FeedbackForm> getAllFeedbackForms() {
        return service.getAllFeedbackForms();
    }
    
    private void sendToQueue(FeedbackForm feedbackForm){
        SentFeedbackForm accountToStore =  new SentFeedbackForm(feedbackForm);
        jmsTemplate.convertAndSend("AccountQueue", accountToStore);
    }
    
//    @GetMapping("/test")
//    public String test() {
//    	return "testing";
//    }
}

