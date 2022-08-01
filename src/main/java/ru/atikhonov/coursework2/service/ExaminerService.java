package ru.atikhonov.coursework2.service;

import ru.atikhonov.coursework2.module.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
