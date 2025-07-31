package com.telusko.questionservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Question") // exact case match
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "TEXT")
	private String questionTitle;
	@Column(columnDefinition = "TEXT")
	private String option1;
	@Column(columnDefinition = "TEXT")
	private String option2;
	@Column(columnDefinition = "TEXT")
	private String option3;
	@Column(columnDefinition = "TEXT")
	private String option4;
	@Column(columnDefinition = "TEXT")
	private String rightAnswer;
	@Column(columnDefinition = "TEXT")
	private String category;
	@Column(columnDefinition = "TEXT")
	private String difficultyLevel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {

		return "Question [id=" + id + ", questionTitle=" + questionTitle + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", rightAnswer=" + rightAnswer
				+ ", category=" + category + "]";
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public Question(Integer id, String questionTitle, String option1, String option2, String option3, String option4,
			String rightAnswer, String category, String difficultyLevel) {
		super();
		this.id = id;
		this.questionTitle = questionTitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rightAnswer = rightAnswer;
		this.category = category;
		this.difficultyLevel = difficultyLevel;
	}

	public Question() {
		super();
	}

}
