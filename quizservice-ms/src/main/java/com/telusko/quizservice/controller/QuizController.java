package com.telusko.quizservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quizservice.model.QuestionWrapper;
import com.telusko.quizservice.model.Quizdto;
import com.telusko.quizservice.model.Response;
import com.telusko.quizservice.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
 
	@Autowired
	QuizService quizservice;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody Quizdto quizdto){
		//System.out.println("nq="+nq);
		return quizservice.createQuiz(quizdto.getCategoryName(),quizdto.getNumQuestions(),quizdto.getTitle());
		//return ResponseEntity.status(HttpStatus.CREATED).body("I am here");
	}
	@GetMapping("create/{id}")
	public ResponseEntity<List<QuestionWrapper>> displayQuiz(@PathVariable Integer id){
		return quizservice.getQuizQuestions(id);
		}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response){
		return quizservice.score(id,response);
		
	}
}
