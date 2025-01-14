// QuizController.java
package com.yourpackage.controller;

import com.yourpackage.model.Question;
import com.yourpackage.model.QuizSession;
import com.yourpackage.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public QuizSession startQuiz() {
        return quizService.startQuiz();
    }

    @GetMapping("/question")
    public Question getRandomQuestion() {
        return quizService.getRandomQuestion();
    }

    @PostMapping("/submit")
    public void submitAnswer(@RequestParam Long sessionId, @RequestParam String answer,
            @RequestParam String correctAnswer) {
        quizService.submitAnswer(sessionId, answer, correctAnswer);
    }

    @GetMapping("/results")
    public QuizSession getResults(@RequestParam Long sessionId) {
        return quizService.getResults(sessionId);
    }
}
