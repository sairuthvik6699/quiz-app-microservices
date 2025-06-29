package com.telusko.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.quizservice.model.*;


@FeignClient("QUESTIONSERVICE-MS")
public interface Quizinterface {

	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numQ );
		
	
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
