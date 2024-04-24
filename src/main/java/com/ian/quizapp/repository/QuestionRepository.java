package com.ian.quizapp.repository;

import com.ian.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByCategory(String category);
    List<Question> findByDifficultyLevel(String difficultyLevel);

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY  RANDOM() LIMIT :numq", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numq);
}
