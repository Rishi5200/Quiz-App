// QuizService.java
package com.yourpackage.service;

import com.yourpackage.model.Question;
import com.yourpackage.model.QuizSession;
import com.yourpackage.repository.QuestionRepository;
import com.yourpackage.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    public QuizSession startQuiz() {
        QuizSession session = new QuizSession();
        session.setQuestionsAnswered(0);
        session.setCorrectAnswers(0);
        session.setIncorrectAnswers(0);
        return quizSessionRepository.save(session);
    }

    public Question getRandomQuestion() {
        return questionRepository.findTopByOrderByIdAsc(); // Fetch a random question
    }

    public void submitAnswer(Long sessionId, String answer, String correctAnswer) {
        QuizSession session = quizSessionRepository.findById(sessionId).orElseThrow();
        session.setQuestionsAnswered(session.getQuestionsAnswered() + 1);
        if (answer.equals(correctAnswer)) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
        }
        quizSessionRepository.save(session);
    }

    public QuizSession getResults(Long sessionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResults'");
    }
}
