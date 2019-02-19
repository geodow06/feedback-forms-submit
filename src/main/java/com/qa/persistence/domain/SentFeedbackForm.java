package com.qa.persistence.domain;

public class SentFeedbackForm {

	private Long feedbackID;
	private int cohortID;
	private int userID;
	private int week;
	private int score;
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	
	public SentFeedbackForm() {
		
	}

	public Long getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(Long feedbackID) {
		this.feedbackID = feedbackID;
	}

	public int getCohortID() {
		return cohortID;
	}

	public void setCohortID(int cohortID) {
		this.cohortID = cohortID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getQuestion4() {
		return question4;
	}

	public void setQuestion4(String question4) {
		this.question4 = question4;
	}
	
	public SentFeedbackForm(FeedbackForm feedbackForm) {
		this.feedbackID = feedbackForm.getFeedbackID();
		this.cohortID = feedbackForm.getCohortID();
		this.userID = feedbackForm.getUserID();
		this.week = feedbackForm.getWeek();
		this.score = feedbackForm.getScore();
		this.question1 = feedbackForm.getQuestion1();
		this.question2 = feedbackForm.getQuestion2();
		this.question3 = feedbackForm.getQuestion3();
		this.question4 = feedbackForm.getQuestion4();
	}
}
