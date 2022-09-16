package ru.spb.curs2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.spb.curs2.exception.LackOfQuestionsException;
import ru.spb.curs2.service.ExaminerService;

@Controller
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get")
    public String getQuestions(@RequestParam("amount") int amount, Model model) throws LackOfQuestionsException {
        model.addAttribute("questions", examinerService.getQuestions(amount));
        return "exam";
    }
}
