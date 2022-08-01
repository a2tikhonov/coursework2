package ru.atikhonov.coursework2.service;

import org.junit.jupiter.api.Test;
import ru.atikhonov.coursework2.exception.QuestionAlreadyExist;
import ru.atikhonov.coursework2.exception.QuestionDoesntExist;
import ru.atikhonov.coursework2.module.JavaQuestionRepositoryImpl;
import ru.atikhonov.coursework2.module.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryImplTest {

    JavaQuestionRepositoryImpl out = new JavaQuestionRepositoryImpl();

    final Question expected = new Question("test", "test");

    @Test
    void add() {
        assertEquals(expected, out.add("test", "test"));
        assertThrows(QuestionAlreadyExist.class, () -> out.add("test", "test"));
    }

    @Test
    void whenAddByObject() {
        Question actual = new Question("test", "test");
        assertEquals(expected, out.add(actual));
        assertThrows(QuestionAlreadyExist.class, () -> out.add("test", "test"));
    }

    @Test
    void remove() {
        assertThrows(QuestionDoesntExist.class, () -> out.remove("test", "test"));
        out.add("test", "test");
        assertEquals(expected, out.remove("test", "test"));
    }

    @Test
    void whenRemoveByObject() {
        Question actual = new Question("test", "test");
        assertThrows(QuestionDoesntExist.class, () -> out.remove(actual));
        out.add(actual);
        assertEquals(expected, out.remove(actual));
    }

    @Test
    void getAll() {
        Collection<Question> expectedCollection = new HashSet<>(Set.of(new Question("test", "test")
                , new Question("test1", "test1")));
        out.add("test", "test");
        out.add("test1", "test1");
        assertEquals(expectedCollection, out.getAll());
    }

/*    @Test
    void getRandomQuestion() {
        out.add("test", "test");
        out.add("test1", "test1");
        out.add("test2", "test2");
        out.add("test3", "test3");
        assertNotNull(out.getRandomQuestion());
        assertInstanceOf(Question.class, out.getRandomQuestion());
    }*/
}