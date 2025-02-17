package com.quizyfy.quizapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizyfy.quizapp.Entities.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
    

}
