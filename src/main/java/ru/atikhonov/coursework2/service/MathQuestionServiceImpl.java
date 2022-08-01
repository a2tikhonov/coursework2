package ru.atikhonov.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.atikhonov.coursework2.module.Question;
import ru.atikhonov.coursework2.module.QuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionServiceImpl implements QuestionService{

    QuestionRepository questions;
    private final Random random;


    public MathQuestionServiceImpl(@Qualifier("mathQuestionRepositoryImpl")QuestionRepository questions) {
        this.random = new Random();
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        return questions.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return questions.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questions.remove(question);
    }

    @Override
    public Question remove(String question, String answer) {
        return questions.remove(question, answer);
    }

    @Override
    public Collection<Question> getAll() {
        return questions.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Question[] questions1 = questions.getAll().toArray(Question[]::new);
        return questions1[random.nextInt(questions1.length)];
    }
}
