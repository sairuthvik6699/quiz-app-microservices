package com.telusko.questionservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.questionservice.dao.Questiondao;
import com.telusko.questionservice.model.Question;
import com.telusko.questionservice.model.QuestionWrapper;
import com.telusko.questionservice.model.Response;

@Service
public class QuestionService {

	@Autowired
	private Questiondao questiondao;

	public ResponseEntity<List<Question>> getAllquestions() {
		try {
			return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String Category) {
		try {
			return new ResponseEntity<>(questiondao.findByCategory(Category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questiondao.save(question);
			return new ResponseEntity<>("Sucess", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> deleteQuestionById(Integer id) {
		try {
			questiondao.deleteById(id);
			return new ResponseEntity<>("sucess", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Integer>> generateQuestions(String category, Integer numQ) {
		List<Question> allQuestions = questiondao.findrandomQuestionBycategerory(category);
		List<Question> questions = allQuestions.stream().limit(numQ).toList();
		List<Integer> questionsId = new ArrayList<>();
		for (Question q : questions) {
			questionsId.add(q.getId());
		}
		return new ResponseEntity<>(questionsId, HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
		List<QuestionWrapper> wrappers = new ArrayList<>();
		List<Question> questions = new ArrayList<>();

		for (Integer id : questionIds) {
			questions.add(questiondao.findById(id).get());
		}
		for (Question question : questions) {
			QuestionWrapper wrapper = new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());
			wrappers.add(wrapper);
		}
		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {

		int right = 0;

		for (Response r : responses) {
			Question question = questiondao.findById(r.getId()).get();
			if (r.getResponse().equals(question.getRightAnswer())) {
				right++;
			}

		}
		return new ResponseEntity<>(right, HttpStatus.OK);

	}

}
