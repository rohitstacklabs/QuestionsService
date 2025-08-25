package com.Quiz.Service;

import java.util.List;
import com.Quiz.Entity.Quiz;

public interface QuizService {
    
    // To add a Quiz
    Quiz add(Quiz quiz);
    
    // To list all Quizzes
    List<Quiz> getAll();
    
    // To retrieve a single Quiz by ID
    Quiz getById(Long id);

}
