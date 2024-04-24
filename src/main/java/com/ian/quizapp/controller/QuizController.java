package com.ian.quizapp.controller;

import com.ian.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numq, @RequestParam String title){

        return new ResponseEntity<>(quizService.createQuiz(category, numq, title), HttpStatus.CREATED);
    }
}
