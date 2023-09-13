package pro.sky.java.course2.examinerservice.service.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {
    Set<Question> questions = new HashSet<>();
    quest
    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int size = questions.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for(Question obj : questions)
        {
            if (i == item)
                return obj;
            i++;
        }
        return null;
    }

}
