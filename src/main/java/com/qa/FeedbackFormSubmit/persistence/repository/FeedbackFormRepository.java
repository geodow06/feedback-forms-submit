package com.qa.FeedbackFormSubmit.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.FeedbackFormSubmit.persistence.domain.FeedbackForm;

public interface FeedbackFormRepository extends JpaRepository<FeedbackForm, Long>{
	
}
