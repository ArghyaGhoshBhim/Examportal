package com.example.examserver.controller.exam;

import com.example.examserver.model.exam.Question;
import com.example.examserver.model.exam.Quiz;
import com.example.examserver.service.exam.QuestionService;
import com.example.examserver.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    @Autowired
    private QuizService quizService;
    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        return  new ResponseEntity<>(questionService.addQuestion(question), HttpStatus.OK);
    }


    @PutMapping("/")
    public ResponseEntity<?>updateQuestion(@RequestBody Question question){
        return  new ResponseEntity<>(questionService.updateQuestion(question), HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<?>getQuestions(){
        return new ResponseEntity<>(questionService.getQuestions(), HttpStatus.OK);
    }

    @GetMapping("/{quesId}")
    public ResponseEntity<?>getQuestion(@PathVariable Long quesId){
        return new ResponseEntity<>(questionService.getQuestion(quesId), HttpStatus.OK);
    }

    @GetMapping("/questionbyqid/{qId}")

    public ResponseEntity<?>getQuestionOfQuiz(@PathVariable Long qId){

        Quiz quiz=quizService.getQuize(qId);
        Set<Question>questionSet=quiz.getQuestions();
        List<Question>list=new ArrayList<>(questionSet);
        Collections.shuffle(list);
        if(list.size()>quiz.getNumberOfQuestion()){
            list.subList(0, quiz.getNumberOfQuestion()+1);
        }

        Collections.shuffle(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @DeleteMapping("/{qId}")
    public ResponseEntity<?>deleteQuize(@PathVariable Long qId){
        questionService.deleteQuestion(qId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
