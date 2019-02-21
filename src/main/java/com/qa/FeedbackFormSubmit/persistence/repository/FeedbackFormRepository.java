package com.qa.FeedbackFormSubmit.persistence.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.FeedbackFormSubmit.persistence.domain.FeedbackForm;

public interface FeedbackFormRepository extends JpaRepository<FeedbackForm, Long>{
	
	public Collection<FeedbackForm> findAllByAccountID(Long id);

}
