package ru.spb.curs2.service;

import org.springframework.stereotype.Service;
import ru.spb.curs2.questionary.Question;
import java.util.HashSet;
import java.util.Iterator;
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
        Question addingQuestion = new Question(question,answer);
        this.questions.add(addingQuestion);
        return addingQuestion;
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
        int randomNumber = random.nextInt(this.questions.size());
        int currentIndex = 0;
        Iterator<? extends Question> iterator = this.questions.iterator();
        Question randomQuestion = null;

        while(iterator.hasNext()){
            randomQuestion = iterator.next();
            if(currentIndex == randomNumber)
                return randomQuestion;
            currentIndex++;
        }
        return randomQuestion;
    }

    public int getSize() {
        return questions.size();
    }
}
