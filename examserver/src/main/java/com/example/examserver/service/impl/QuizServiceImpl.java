package com.example.examserver.service.impl;

import com.example.examserver.dao.exam.QuizRepository;
import com.example.examserver.model.exam.Category;
import com.example.examserver.model.exam.Quiz;
import com.example.examserver.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new LinkedHashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuize(Long id) {
        return this.quizRepository.findById(id).get();
    }

    @Override
    public void deleteQuize(Long id) {
        this.quizRepository.deleteById(id);
    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return quizRepository.findByCategory(category);
    }

//    find all active quize only
    @Override
    public List<Quiz> findByActive() {
        return quizRepository.findByActive(true);
    }
//find quize of a category those are active.
    @Override
    public List<Quiz> findByCategoryAndActive(Category category) {
        return quizRepository.findByCategoryAndActive(category, true);
    }
}
