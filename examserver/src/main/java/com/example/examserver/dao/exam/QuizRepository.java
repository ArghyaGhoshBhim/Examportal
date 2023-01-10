package com.example.examserver.dao.exam;

import com.example.examserver.model.exam.Category;
import com.example.examserver.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz>findByCategory(Category category);
    List<Quiz>findByActive(boolean active);
    List<Quiz>findByCategoryAndActive(Category category, boolean active);
}
