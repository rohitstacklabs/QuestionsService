package com.Quiz.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.Quiz.Entity.Quiz;
import com.Quiz.Repository.QuizRespository;
import com.Quiz.Service.QuestionClient;
import com.Quiz.Service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	private final QuizRespository quizRespository;
	private QuestionClient questionClient;

	public QuizServiceImpl(QuizRespository quizRespository, QuestionClient questionClient) {
		this.quizRespository = quizRespository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRespository.save(quiz);
	}

	@Override
	public List<Quiz> getAll() {

		List<Quiz> quizs = quizRespository.findAll();

		List<Quiz> newQuizs = quizs.stream().map(Quiz -> {
			Quiz.setQuestions(questionClient.getQuestionOfQuiz(Quiz.getId()));
			return Quiz;
		}).collect(Collectors.toList());
		return newQuizs;
	}

	@Override
	public Quiz getById(Long id) {

		Quiz quiz = quizRespository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));

		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}
}
