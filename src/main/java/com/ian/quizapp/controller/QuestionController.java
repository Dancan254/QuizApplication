package com.ian.quizapp.controller;

import com.ian.quizapp.dto.QuestionDto;
import com.ian.quizapp.model.Question;
import com.ian.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<QuestionDto>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<QuestionDto>> getQuestionsByCategory(@PathVariable String category){
        return new ResponseEntity<>(questionService.getQuestionsByCategory(category), HttpStatus.FOUND);
    }
    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<QuestionDto>> getQuestionsByDifficulty(@PathVariable String difficulty){
        return new ResponseEntity<>(questionService.getQuestionsByDifficulty(difficulty), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return new ResponseEntity<>(questionService.addQuestion(question), HttpStatus.CREATED);
    }
}
