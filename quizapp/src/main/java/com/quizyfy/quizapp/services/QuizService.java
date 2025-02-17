package com.quizyfy.quizapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizyfy.quizapp.Dao.QuestionDao;
import com.quizyfy.quizapp.Dao.QuizDao;
import com.quizyfy.quizapp.Entities.Question;
import com.quizyfy.quizapp.Entities.Quiz;
import com.quizyfy.quizapp.Entities.WrapperQutions;

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

        return new ResponseEntity<>("Success ", HttpStatus.OK);
    }

    public ResponseEntity<List<WrapperQutions>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);

        List<Question> questionsFromDb = quiz.get().getQuestions();
        List<WrapperQutions> qWrapperQutions = new ArrayList<>();
        for (Question q : questionsFromDb) {
            WrapperQutions wrapperclassobj = new WrapperQutions(q.getId(), q.getQuestion_text(), q.getOption1(),
                    q.getOption2(), q.getOption3(), q.getOption4());

        }

        return new ResponseEntity<>(qWrapperQutions, HttpStatus.OK);
    }

}
