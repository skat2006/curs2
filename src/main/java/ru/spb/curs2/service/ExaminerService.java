package ru.spb.curs2.service;

import ru.spb.curs2.exception.LackOfQuestionsException;
import ru.spb.curs2.questionary.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount) throws LackOfQuestionsException;
}
