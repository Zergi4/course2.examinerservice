package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.QuestionsAmountException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService service;
    Random random = new Random();

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > service.getAll().size()) {
            throw new QuestionsAmountException();
        }
        if (service.getAll().size() == amount) {
            return service.getAll();

        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(service.getRandomQuestion());
        }
        return result;
    }
}
