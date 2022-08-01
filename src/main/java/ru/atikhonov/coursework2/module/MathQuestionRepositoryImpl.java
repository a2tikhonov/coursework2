package ru.atikhonov.coursework2.module;

import org.springframework.stereotype.Repository;
import ru.atikhonov.coursework2.exception.QuestionAlreadyExist;
import ru.atikhonov.coursework2.exception.QuestionDoesntExist;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepositoryImpl implements QuestionRepository {

    private final Collection<Question> questions;


    public MathQuestionRepositoryImpl() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add("mathtest0", "mathtest0");
        add("mathtest1", "mathtest1");
        add("mathtest2", "mathtest2");
        add("mathtest3", "mathtest3");
        add("mathtest4", "mathtest4");
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExist();
        } else {
            questions.add(question);
        }
        return question;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (getAll().stream()
                .anyMatch(p -> p.getQuestion().equals(question))) {
            throw new QuestionAlreadyExist();
        } else {
            questions.add(newQuestion);
        }
        return newQuestion;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionDoesntExist();
        } else {
            questions.remove(question);
        }
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (!questions.contains(question1)) {
            throw new QuestionDoesntExist();
        } else {
            questions.remove(question1);
        }
        return question1;
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }
}
