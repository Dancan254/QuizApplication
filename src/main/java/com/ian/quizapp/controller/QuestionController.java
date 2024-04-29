package com.ian.quizapp.controller;

import com.ian.quizapp.dto.QuestionDto;
import com.ian.quizapp.model.Question;
import com.ian.quizapp.services.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "get all questions")
    @ApiResponses(
            value  = {
                    @ApiResponse(responseCode = "200", description = "questions fetched successfully",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = QuestionDto.class)))
                            }
                    )
            }
    )
    @GetMapping("/questions/all")
    public ResponseEntity<List<QuestionDto>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }


    @Operation(summary = "get questions by category")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "302", description = "questions fetched successfully",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = QuestionDto.class)))
                            }
                    )
            }
    )
    @GetMapping("/category/{category}")
    public ResponseEntity<List<QuestionDto>> getQuestionsByCategory(@PathVariable String category){
        return new ResponseEntity<>(questionService.getQuestionsByCategory(category), HttpStatus.FOUND);
    }
    //document the api
    @Operation(summary = "get questions by difficulty")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "questions fetched successfully",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = QuestionDto.class)))
                            }
                    )
            }
    )
    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<QuestionDto>> getQuestionsByDifficulty(@PathVariable String difficulty){
        return new ResponseEntity<>(questionService.getQuestionsByDifficulty(difficulty), HttpStatus.OK);
    }

    //document the api
    @Operation(summary = "add a question")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "question added successfully",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = Question.class))
                            }
                    )
            }
    )
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return new ResponseEntity<>(questionService.addQuestion(question), HttpStatus.CREATED);
    }
}
