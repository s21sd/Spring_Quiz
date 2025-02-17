package com.quizyfy.quizapp.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizyfy.quizapp.Entities.Question;
import com.quizyfy.quizapp.Entities.Quiz;
import com.quizyfy.quizapp.services.QuizService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    // http://localhost:8080/quiz/create?category=java&noOfQuestion=5&title=jQuiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noOfQuestion,
            @RequestParam String title) {

        quizService.createQuiz(category, noOfQuestion, title);

        return new ResponseEntity<>("Success ", HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<Question>> getQuizQuestions(@PathVariable Integer id) {

    }

}
