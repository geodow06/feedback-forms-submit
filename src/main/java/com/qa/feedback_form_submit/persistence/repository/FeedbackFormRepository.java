package com.qa.feedback_form_submit.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.feedback_form_submit.persistence.domain.FeedbackForm;

public interface FeedbackFormRepository extends JpaRepository<FeedbackForm, Long>{

}
