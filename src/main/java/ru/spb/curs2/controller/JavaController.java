package ru.spb.curs2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spb.curs2.exception.LackOfQuestionsException;
import ru.spb.curs2.exception.QuestionAlreadyAddedException;
import ru.spb.curs2.exception.QuestionNotFoundException;
import ru.spb.curs2.questionary.Question;
import ru.spb.curs2.service.QuestionService;

@Controller
@RequestMapping(path = "/exam")
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/java")
    public String getQuestion(@ModelAttribute Question question,Model model) {
        model.addAttribute("questionList", questionService.getQuestions());
        return "work";
    }

    @PostMapping("/java/add")
    public String addQuestion(@ModelAttribute Question question, Model model) {
        model.addAttribute("question", question);
        questionService.addQuestion(question);
        model.addAttribute("questionList", questionService.getQuestions());
        return "work";
    }

    @PostMapping("/java/remove")
    public String removeQuestion(@ModelAttribute Question question, Model model) {
        model.addAttribute("question", question);
        questionService.removeQuestion(question);
        model.addAttribute("questionList", questionService.getQuestions());
        return "work";
    }

    @ResponseBody
    @ExceptionHandler(LackOfQuestionsException.class)
    public String lackOfQuestions() {
        return "Requested amount is higher that quests in DB.";
    }
}
