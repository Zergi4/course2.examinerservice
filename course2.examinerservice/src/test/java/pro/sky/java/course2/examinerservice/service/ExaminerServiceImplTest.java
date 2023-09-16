package pro.sky.java.course2.examinerservice.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.QuestionsAmountException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService javaQuestionServiceMock;

    @InjectMocks
    ExaminerServiceImpl service;

    @Test
    void testGetRandomWhenEmplty() {
        when(javaQuestionServiceMock.getAll()).thenReturn(Collections.emptySet());
        assertThrows(QuestionsAmountException.class, () -> service.getQuestions(1));

    }

    @Test
    void testWhenAmountEqSize() {
        var qa = Set.of(new Question("Question", "Answer"));
        when(javaQuestionServiceMock.getAll()).thenReturn(qa);
        assertSame(qa, service.getQuestions(1));

    }

    @Test
    void testLessAmountEqSize() {
        var qa = Set.of(new Question("q1", "a1"), new Question("q2", "a2"), new Question("q3", "a3"));
        when(javaQuestionServiceMock.getAll()).thenReturn(qa);
        when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(new Question("q1", "a1"),
                        new Question("q2", "a2")
                        , new Question("q1", "a1"));

        var actual = service.getQuestions(2);
        org.assertj.core.api.Assertions.assertThat(actual).containsExactly(
                new Question("q1", "a1"),
                new Question("q2", "a2"));
    }

}