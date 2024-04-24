package com.ian.quizapp.repository;

import com.ian.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Long> {
}
