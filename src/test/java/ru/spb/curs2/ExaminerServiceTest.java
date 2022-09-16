package ru.spb.curs2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spb.curs2.questionary.Question;
import ru.spb.curs2.service.ExaminerServiceImpl;
import ru.spb.curs2.service.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;


    @BeforeEach
    public void beforeEach() {
        Question question = new Question("Что такое арбуз?", "Фрукт");
        when(questionService.getRandomQuestion()).thenReturn(question);
//        when(questionService.getSize()).thenReturn(5);
    }

    @Test
    public void getQuestionsTest() {
        Set<Question> questionList = new HashSet<>();
        questionList.add(questionService.getRandomQuestion());
        Assertions.assertEquals(questionList.size(), 1);
    }
}
