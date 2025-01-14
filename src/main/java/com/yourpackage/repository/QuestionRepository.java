package com.yourpackage.repository;

import com.yourpackage.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Custom query to fetch random questions
    Question findTopByOrderByIdAsc();
}