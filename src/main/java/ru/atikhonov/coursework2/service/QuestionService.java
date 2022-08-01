package ru.atikhonov.coursework2.service;

import ru.atikhonov.coursework2.module.Question;

import java.util.Collection;


public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();

}
