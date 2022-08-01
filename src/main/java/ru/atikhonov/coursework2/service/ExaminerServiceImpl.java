package ru.atikhonov.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.atikhonov.coursework2.exception.RequestedMoreQuestionsThanExistException;
import ru.atikhonov.coursework2.module.Question;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    private final Random random;


    public ExaminerServiceImpl(@Qualifier("javaQuestionServiceImpl") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionServiceImpl") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        random = new Random();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<QuestionService> questionServiceList = List.of(javaQuestionService, mathQuestionService);
        if (amount <= 0 || amount > questionServiceList.stream().map(p -> p.getAll()).mapToInt(n -> n.size()).sum()) {
            throw new RequestedMoreQuestionsThanExistException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            int index = random.nextInt(questionServiceList.size());
            questions.add(questionServiceList.get(index).getRandomQuestion());
        }
        return questions;
    }

}
