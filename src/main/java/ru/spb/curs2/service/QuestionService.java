package ru.spb.curs2.service;

import ru.spb.curs2.questionary.Question;
import java.util.Collection;

public interface QuestionService {
    Question addQuestion(String question, String answer);
    Question addQuestion(Question question);
    Question removeQuestion(Question question);
    Collection<Question> getQuestions();
    Question getRandomQuestion();
    int getSize();
}
