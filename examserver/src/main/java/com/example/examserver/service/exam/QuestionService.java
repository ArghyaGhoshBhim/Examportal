package com.example.examserver.service.exam;

import com.example.examserver.model.exam.Question;

import com.example.examserver.model.exam.Quiz;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public interface QuestionService {

    Question addQuestion(Question question);

    Question updateQuestion(Question question);

    Set<Question> getQuestions();

    Question getQuestion(Long id);

    Set<Question>getQuestionOfQuiz(Quiz quiz);
    void deleteQuestion(Long id);

}
