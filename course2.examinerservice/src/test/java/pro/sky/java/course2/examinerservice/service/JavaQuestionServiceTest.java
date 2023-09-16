package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService service = new JavaQuestionService();
    @BeforeEach
    public void beforeEach() {
        service.getAll().clear();
    }

    @Test
    void add() {
        Set<Question> set = new HashSet<>();
        set.add(new Question("Question", "Answer"));
        service.add("Question", "Answer");
        assertEquals(set, service.getAll());
        Question result = service.add(new Question("test","test"));
        Assertions.assertEquals(new Question("test","test"), result);
    }

    @Test
    void testAdd() {
    }

    @Test
    void remove() {
        Question q1 = new Question("test", "test");
        Question q2 = new Question("test2", "test2");
        service.add(q1);
        service.add(q2);

        Question result = service.remove(q1);
        Assertions.assertNotNull(service);
        Assertions.assertEquals(q1, result);
        Assertions.assertFalse(service.toString().contains(q1.toString()));
    }

    @Test
    void getAll() {
        Assertions.assertTrue(service.getAll().isEmpty());
        Question q1 = new Question("question", "answer");
        Question q2 = new Question("question2", "answer2");
        service.add(q1);
        service.add(q2);
        Set<Question> expected = new HashSet<>(Set.of(new Question("question", "answer"),
                new Question("question2", "answer2")));
        Assertions.assertEquals(expected, service.getAll());
    }

    @Test
    void getRandomQuestion() {
        Question q1 = new Question("question", "answer");
        service.add(q1);
        Question result = service.getRandomQuestion();
        Assertions.assertEquals(q1, result);
    }
}