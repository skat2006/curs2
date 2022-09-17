package ru.spb.curs2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.spb.curs2.questionary.Question;
import ru.spb.curs2.service.JavaQuestionService;
import ru.spb.curs2.service.QuestionService;

import java.util.stream.Stream;

public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @ParameterizedTest
    @MethodSource("params")
    public void addQuestionTest(String question, String answer) {
        Question expected = new Question(question, answer);
        Assertions.assertEquals(questionService.addQuestion(question, answer), expected);
        Assertions.assertEquals(questionService.getSize(), 1);
        questionService.addQuestion(new Question("test", "test"));
        Assertions.assertEquals(questionService.getSize(), 2);
    }

    @ParameterizedTest
    @MethodSource("params")
    public void removeQuestionTest(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionService.addQuestion(newQuestion);
        questionService.addQuestion("test", "test");
        Assertions.assertEquals(questionService.getSize(), 2);
        questionService.removeQuestion(newQuestion);
        Assertions.assertEquals(questionService.getSize(), 1);
    }

    @ParameterizedTest
    @MethodSource("params")
    public void getRandomQuestionTest(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionService.addQuestion(newQuestion);
        Assertions.assertEquals(questionService.getRandomQuestion(), newQuestion);
    }

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("Что такое арбуз?", "Фрукт"),
                Arguments.of("Что такое картошка?", "Овощь"),
                Arguments.of("Будешь?", "Ага")
        );
    }
}
