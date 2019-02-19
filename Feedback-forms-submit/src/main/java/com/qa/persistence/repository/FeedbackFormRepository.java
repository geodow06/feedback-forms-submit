package com.qa.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.persistence.domain.FeedbackForm;

public interface FeedbackFormRepository extends JpaRepository<FeedbackForm, Long>{

}
