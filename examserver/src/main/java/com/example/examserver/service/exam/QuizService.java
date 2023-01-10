package com.example.examserver.service.exam;

import com.example.examserver.model.exam.Category;
import com.example.examserver.model.exam.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public interface QuizService {
    Quiz addQuiz(Quiz quiz);

    Quiz updateQuiz(Quiz quiz);

    Set<Quiz> getQuizzes();

    Quiz getQuize(Long id);

    void deleteQuize(Long id);

    List<Quiz> getQuizzesOfCategory(Category category);
    List<Quiz>findByActive();
    List<Quiz>findByCategoryAndActive(Category category);
}
