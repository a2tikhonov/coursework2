package ru.atikhonov.coursework2.service;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.atikhonov.coursework2.exception.QuestionAlreadyExist;
import ru.atikhonov.coursework2.exception.QuestionDoesntExist;
import ru.atikhonov.coursework2.module.JavaQuestionRepositoryImpl;
import ru.atikhonov.coursework2.module.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceImplTest {

    @Mock
    private JavaQuestionRepositoryImpl javaQuestionRepositoryMock;

    @InjectMocks
    private JavaQuestionServiceImpl out;

    final Question expected = new Question("test", "test");

    @Test
    void add() {
        when(javaQuestionRepositoryMock.add(anyString(), anyString())).thenReturn(expected);
        assertEquals(expected, out.add("test", "test"));
        when(javaQuestionRepositoryMock.add(anyString(), anyString())).thenThrow(QuestionAlreadyExist.class);
        assertThrows(QuestionAlreadyExist.class, () -> out.add(anyString(), anyString()));
    }

    @Test
    void whenAddByObject() {
        when(javaQuestionRepositoryMock.add(any())).thenReturn(expected);
        assertEquals(expected, out.add(new Question("test", "test")));
        when(javaQuestionRepositoryMock.add(any())).thenThrow(QuestionAlreadyExist.class);
        assertThrows(QuestionAlreadyExist.class, () -> out.add(expected));
    }

    @Test
    void remove() {
        when(javaQuestionRepositoryMock.remove(anyString(), anyString())).thenReturn(expected);
        assertEquals(expected, out.remove("test", "test"));
        when(javaQuestionRepositoryMock.remove(anyString(), anyString())).thenThrow(QuestionDoesntExist.class);
        assertThrows(QuestionDoesntExist.class, () -> out.remove(anyString(), anyString()));
    }

    @Test
    void whenRemoveByObject() {
        when(javaQuestionRepositoryMock.remove(any())).thenReturn(expected);
        assertEquals(expected, out.remove(new Question("test", "test")));
        when(javaQuestionRepositoryMock.remove(any())).thenThrow(QuestionDoesntExist.class);
        assertThrows(QuestionDoesntExist.class, () -> out.remove(expected));
    }

    @Test
    void getAll() {
        Collection<Question> expectedCollection = new HashSet<>(Set.of(new Question("test", "test")
                , new Question("test1", "test1")));
        when(javaQuestionRepositoryMock.getAll()).thenReturn(new HashSet<>(Set.of(new Question("test", "test")
                , new Question("test1", "test1"))));
        assertEquals(expectedCollection, out.getAll());
    }

    @Test
    void getRandomQuestion() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(new HashSet<>(Set.of(
                new Question("test", "test")
                , new Question("test1", "test1")
                , new Question("test2", "test2"))));
        assertInstanceOf(Question.class, out.getRandomQuestion());
        assertThat(out.getRandomQuestion().getQuestion(), containsString("test"));
    }
}