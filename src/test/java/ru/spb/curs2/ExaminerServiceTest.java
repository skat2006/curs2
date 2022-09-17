package ru.spb.curs2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spb.curs2.exception.LackOfQuestionsException;
import ru.spb.curs2.questionary.Question;
import ru.spb.curs2.service.ExaminerServiceImpl;
import ru.spb.curs2.service.JavaQuestionService;

import java.util.Collection;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void before() {
        when(questionService.getSize()).thenReturn(5);
    }

    @Test
    public void getQuestionsTest() {
        when(questionService.getRandomQuestion()).thenReturn(new Question("Что такое арбуз?", "Фрукт"));
        Collection<Question> questionList = examinerService.getQuestions(1);
        Assertions.assertEquals(questionList.size(), 1);
    }

    @Test
    public void negativeGetQuestionTest() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(LackOfQuestionsException.class)                    //не работают assertions, я запарился...
                .isThrownBy(() -> examinerService.getQuestions(7));
    }
}
