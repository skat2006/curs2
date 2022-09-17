package ru.spb.curs2.service;

import org.springframework.stereotype.Service;
import ru.spb.curs2.exception.LackOfQuestionsException;
import ru.spb.curs2.exception.WrongQuestionsAmountException;
import ru.spb.curs2.questionary.Question;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws LackOfQuestionsException {
        if (amount < 1) throw new WrongQuestionsAmountException();

        Set<Question> questionList = new HashSet<>();
        if (questionService.getSize() >= amount) {
            while (questionList.size() < amount) {
                questionList.add(questionService.getRandomQuestion());
            }
        } else {
            throw new LackOfQuestionsException();
        }
        return questionList;
    }
}
