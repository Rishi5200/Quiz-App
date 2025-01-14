package com.yourpackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourpackage.model.QuizSession;

public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {
}