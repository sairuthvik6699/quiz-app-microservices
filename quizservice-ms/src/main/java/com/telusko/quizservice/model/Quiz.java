package com.telusko.quizservice.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,  generator = "question_seq")
	@SequenceGenerator(name = "question_seq", sequenceName = "question_seq", allocationSize = 1)
	private int id;
	
	private String title;
	@ElementCollection
	private List<Integer> questionids;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Integer> getQuestionids() {
		return questionids;
	}
	public void setQuestionids(List<Integer> questionids) {
		this.questionids = questionids;
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", questionids=" + questionids + "]";
	}
	public Quiz(int id, String title, List<Integer> questionids) {
		super();
		this.id = id;
		this.title = title;
		this.questionids = questionids;
	}
	public Quiz() {
		super();
	}
	
	
	
	

}
