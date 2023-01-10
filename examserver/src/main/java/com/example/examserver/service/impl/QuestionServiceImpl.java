package com.example.examserver.service.impl;

import com.example.examserver.dao.exam.QuestionRepository;
import com.example.examserver.model.exam.Question;
import com.example.examserver.model.exam.Quiz;
import com.example.examserver.service.exam.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question quiz) {
        return this.questionRepository.save(quiz);
    }

    @Override
    public Question updateQuestion(Question quiz) {
        return this.questionRepository.save(quiz);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>( this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long id) {
        return this.questionRepository.findById(id).get();
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long id) {
        this.questionRepository.deleteById(id);
    }
}
