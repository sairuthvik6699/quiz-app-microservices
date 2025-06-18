package com.telusko.quizservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.telusko.quizservice.dao.Quizdao;
import com.telusko.quizservice.feign.Quizinterface;

import com.telusko.quizservice.model.QuestionWrapper;
import com.telusko.quizservice.model.Quiz;
import com.telusko.quizservice.model.Response;

@Service
public class QuizService {
	
	@Autowired
	Quizdao quizdao;
	
	@Autowired
	Quizinterface quizinterface;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

		List<Integer> questions = quizinterface.getQuestionsForQuiz(category, numQ).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionids(questions);
		quizdao.save(quiz);
		return new ResponseEntity<>("sucess",HttpStatus.CREATED);
	}
	
   public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id){
	   
	   Quiz quiz = quizdao.findById(id).get();
	   List<Integer> questionIds = quiz.getQuestionids();
	   System.out.println(questionIds);
	   ResponseEntity<List<QuestionWrapper>> questions = quizinterface.getQuestionsFromId(questionIds);
	   
			return questions;
			   
   }

public ResponseEntity<Integer> score(Integer id, List<Response> response) {
	
	ResponseEntity<Integer> result = quizinterface.getScore(response);
	
	return result;
}


}
