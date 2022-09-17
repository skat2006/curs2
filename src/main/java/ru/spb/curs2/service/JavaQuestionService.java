package ru.spb.curs2.service;

import org.springframework.stereotype.Service;
import ru.spb.curs2.questionary.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {
    private final Random random = new Random();
    private final Set<Question> questions;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Set<Question> getQuestions() {
        return this.questions;
    }

    @Override
    public Question addQuestion(String question, String answer) {
        return addQuestion(new Question(question, answer));
    }

    @Override
    public Question addQuestion(Question question) {
        this.questions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(Question question) {
        this.questions.remove(question);
        return question;
    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }

    public int getSize() {
        return questions.size();
    }
}
