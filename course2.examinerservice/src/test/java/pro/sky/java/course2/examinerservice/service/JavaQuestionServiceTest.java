package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService out = new JavaQuestionService();
    @BeforeEach
    public void beforeEach() {
        out.getAll().clear();
    }

    @Test
    void add() {
        Set<Question> set = new HashSet<>();
        set.add(new Question("Question", "Answer"));
        out.add("Question", "Answer");
        assertEquals(set, out.getAll());
        Question result = out.add(new Question("test","test"));
        Assertions.assertEquals(new Question("test","test"), result);
    }

    @Test
    void testAdd() {
    }

    @Test
    void remove() {
        Question q1 = new Question("test", "test");
        Question q2 = new Question("test2", "test2");
        out.add(q1);
        out.add(q2);

        Question result = out.remove(q1);
        Assertions.assertNotNull(out);
        Assertions.assertEquals(q1, result);
        Assertions.assertFalse(out.toString().contains(q1.toString()));
    }

    @Test
    void getAll() {
        Assertions.assertTrue(out.getAll().isEmpty());
        Question q1 = new Question("question", "answer");
        Question q2 = new Question("question2", "answer2");
        out.add(q1);
        out.add(q2);
        Set<Question> expected = new HashSet<>(Set.of(new Question("question", "answer"),
                new Question("question2", "answer2")));
        Assertions.assertEquals(expected, out.getAll());
    }

    @Test
    void getRandomQuestion() {
        Question q1 = new Question("question", "answer");
        out.add(q1);
        Question result = out.getRandomQuestion();
        Assertions.assertEquals(q1, result);
    }
}