package com.example.examserver.controller.exam;


import com.example.examserver.model.exam.Category;
import com.example.examserver.model.exam.Quiz;
import com.example.examserver.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizeController {



    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<?>addQuiz(@RequestBody Quiz quiz){
        return  new ResponseEntity<>(quizService.addQuiz(quiz), HttpStatus.OK);
    }


    @PutMapping("/")
    public ResponseEntity<?>updateQuiz(@RequestBody Quiz quiz){
        return new ResponseEntity<>(quizService.updateQuiz(quiz), HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<?>getQuizzes(){
        return new ResponseEntity<>(quizService.getQuizzes(), HttpStatus.OK);
    }

    @GetMapping("/{qId}")
    public ResponseEntity<?>getQuize(@PathVariable Long qId){
        return new ResponseEntity<>(quizService.getQuize(qId), HttpStatus.OK);
    }

    @DeleteMapping("/{qId}")
    public ResponseEntity<?>deleteQuize(@PathVariable Long qId){
        quizService.deleteQuize(qId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/category/{cId}")
    public ResponseEntity<?>getQuizzesOfCategory(@PathVariable long cId){
        Category category=new Category();
        category.setcId(cId);
        return new ResponseEntity<>(quizService.getQuizzesOfCategory(category), HttpStatus.OK);
    }

    //    find all active quize only

    @GetMapping("/active")
    public ResponseEntity<?>findByActive() {
        return new ResponseEntity<>(quizService.findByActive(), HttpStatus.OK);

    }
    //find quize of a category those are active.

    @GetMapping("/active/category/{cId}")
    public ResponseEntity<?>findByCategoryAndActive(@PathVariable long cId) {
        Category category=new Category();
        category.setcId(cId);
        return new ResponseEntity<>(quizService.findByCategoryAndActive(category), HttpStatus.OK);
    }
}
