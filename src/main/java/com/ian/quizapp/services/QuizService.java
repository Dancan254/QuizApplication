package com.ian.quizapp.services;

import com.ian.quizapp.model.Question;
import com.ian.quizapp.model.Quiz;
import com.ian.quizapp.repository.QuestionRepository;
import com.ian.quizapp.repository.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionRepository questionRepository;

    public String createQuiz(String category, int numq, String title) {
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numq);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return "Quiz created successfully";
    }
}
