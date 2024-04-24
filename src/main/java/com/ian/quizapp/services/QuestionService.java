package com.ian.quizapp.services;

import com.ian.quizapp.dto.QuestionDto;
import com.ian.quizapp.model.Question;
import com.ian.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    public List<QuestionDto> getAllQuestions() {
        try {
            List<Question> questions = questionRepository.findAll();

            return questions.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    private QuestionDto convertToDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setQuestionTitle(question.getQuestionTitle());
        questionDto.setOption1(question.getOption1());
        questionDto.setOption2(question.getOption2());
        questionDto.setOption3(question.getOption3());
        questionDto.setOption4(question.getOption4());
        questionDto.setCategory(question.getCategory());
        questionDto.setDifficultyLevel(question.getDifficultyLevel());
        return questionDto;
    }

    public List<QuestionDto> getQuestionsByCategory(String category) {
        try {
            List<Question> questions = questionRepository.findByCategory(category);
            return questions.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }catch(Exception e){
            return new ArrayList<>();
        }
    }

    public List<QuestionDto> getQuestionsByDifficulty(String difficulty) {
        try {
            List<Question> questions = questionRepository.findByDifficultyLevel(difficulty);
            return questions.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }

    }

    public String addQuestion(Question question) {
        try {
            questionRepository.save(question);
            return "Successfully added a " + question.getCategory() + " question";
        }catch (Exception e){
            return "Failed";
        }
    }
}
