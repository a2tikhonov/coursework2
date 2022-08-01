package ru.atikhonov.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import ru.atikhonov.coursework2.exception.RequestedMoreQuestionsThanExistException;
import ru.atikhonov.coursework2.module.Question;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionServiceImpl javaQuestionServiceMock;

    @Mock
    private MathQuestionServiceImpl mathQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void getQuestions() {
/*        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question("javatest", "test"),
                new Question("javatest1", "test1"),
                new Question("javatest2", "test2"),
                new Question("javatest3", "test3"
        ));
        when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question("mathtest", "test"),
                new Question("mathtest1", "test1"),
                new Question("mathtest2", "test2"),
                new Question("mathtest3", "test3"
                ));
        Random random = new Random();
        ReflectionTestUtils.setField(javaQuestionServiceMock, "random", random);
        ReflectionTestUtils.setField(mathQuestionServiceMock, "random", random);
        lenient().when(javaQuestionServiceMock.getRandomQuestion()).thenCallRealMethod();
        lenient().when(mathQuestionServiceMock.getRandomQuestion()).thenCallRealMethod();
        assertThat(out.getQuestions(4)).containsAnyElementsOf()*/
/*        assertThrows(RequestedMoreQuestionsThanExistException.class, () -> out.getQuestions(-1));
        assertThrows(RequestedMoreQuestionsThanExistException.class, () -> out.getQuestions(1));
        Question q0 = new Question("test", "test");
        Question q1 = new Question("test1", "test1");
        Question q2 = new Question("test2", "test2");
        Question q3 = new Question("test3", "test3");
        List<Question> expectedCollection = new ArrayList<>(Set.of(q0, q1, q2, q3));
        when(javaQuestionServiceMock.getAll()).thenReturn(expectedCollection);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(expectedCollection.get(0)
        ,expectedCollection.get(1), expectedCollection.get(2), expectedCollection.get(3));
        assertThat(expectedCollection).hasSameElementsAs(out.getQuestions(4));
        verify(javaQuestionServiceMock, times(4)).getRandomQuestion();*/
    }
}