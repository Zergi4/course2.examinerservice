package pro.sky.java.course2.examinerservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")

public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }
    @GetMapping()
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }


}
