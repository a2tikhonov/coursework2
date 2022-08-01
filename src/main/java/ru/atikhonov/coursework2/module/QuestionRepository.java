package ru.atikhonov.coursework2.module;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question add(String question, String answer);

    Question remove(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

}
