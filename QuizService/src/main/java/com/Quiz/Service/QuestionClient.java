package com.Quiz.Service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Quiz.Entity.Question;

@FeignClient(url = "http://localhost:8082", value = "Question-Client")
public interface QuestionClient {
	
	@GetMapping("/Question/quiz/{quizid}")
	List<Question> getQuestionOfQuiz(@PathVariable Long quizid);

}

