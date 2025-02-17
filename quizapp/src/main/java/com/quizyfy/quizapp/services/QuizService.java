package com.quizyfy.quizapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizyfy.quizapp.Dao.QuestionDao;
import com.quizyfy.quizapp.Dao.QuizDao;
import com.quizyfy.quizapp.Entities.Question;
import com.quizyfy.quizapp.Entities.Quiz;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int noOfQuestion, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, noOfQuestion);
        Quiz quiz = new Quiz();
        // quiz.setId(id);
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("This is ", HttpStatus.OK);
    }

}
