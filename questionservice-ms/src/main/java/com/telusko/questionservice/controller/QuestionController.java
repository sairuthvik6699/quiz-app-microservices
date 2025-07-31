package com.telusko.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.questionservice.model.Question;
import com.telusko.questionservice.model.QuestionWrapper;
import com.telusko.questionservice.model.Response;
import com.telusko.questionservice.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	private QuestionService questionservice;

	@GetMapping("allquestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionservice.getAllquestions();

	}

	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategoryte(@PathVariable String category) {
		return questionservice.getQuestionsByCategory(category);
	}

	@PostMapping("allquestions")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionservice.addQuestion(question);
	}

	@DeleteMapping("allquestions/{id}")
	public ResponseEntity<String> deleteQuestionById(@PathVariable Integer id) {
		return questionservice.deleteQuestionById(id);
	}

	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,
			@RequestParam Integer numQ) {
		return questionservice.generateQuestions(category, numQ);

	}

	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
		return questionservice.getQuestionsFromId(questionIds);

	}

	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
		return questionservice.getScore(responses);

	}

}
