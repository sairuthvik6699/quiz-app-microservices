package com.telusko.questionservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telusko.questionservice.model.Question;

@Repository
public interface Questiondao extends JpaRepository<Question, Integer> {

	public List<Question> findByCategory(String category);

	@Query(value = "SELECT * FROM question q Where q.category=:category  ORDER BY RAND()  ", nativeQuery = true)
	public List<Question> findrandomQuestionBycategerory(@Param("category") String category);

}
