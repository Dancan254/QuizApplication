package com.ian.quizapp.controller;

import com.ian.quizapp.services.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    //document the api
    @Operation(summary = "create a quiz")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "quiz created successfully")
            }
    )
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numq, @RequestParam String title){

        return new ResponseEntity<>(quizService.createQuiz(category, numq, title), HttpStatus.CREATED);
    }
}
