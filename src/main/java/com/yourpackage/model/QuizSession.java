package com.yourpackage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class QuizSession {
    @Id
    private Long id;
    private int questionsAnswered;
    private int correctAnswers;
    private int incorrectAnswers;
    public void setQuestionsAnswered(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setQuestionsAnswered'");
    }
    public void setCorrectAnswers(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCorrectAnswers'");
    }
    public void setIncorrectAnswers(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIncorrectAnswers'");
    }
    public int getQuestionsAnswered() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQuestionsAnswered'");
    }
    public int getCorrectAnswers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCorrectAnswers'");
    }
    public int getIncorrectAnswers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIncorrectAnswers'");
    }
}
