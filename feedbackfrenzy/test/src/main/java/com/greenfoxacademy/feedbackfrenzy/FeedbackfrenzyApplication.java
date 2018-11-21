package com.greenfoxacademy.feedbackfrenzy;

import com.greenfoxacademy.feedbackfrenzy.model.Question;
import com.greenfoxacademy.feedbackfrenzy.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeedbackfrenzyApplication implements CommandLineRunner {
    private QuestionRepository questionRepository;

    public FeedbackfrenzyApplication(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeedbackfrenzyApplication.class, args);
    }

    public void run(String... args) throws Exception {
        Question question1 = new Question();
        question1.setName("What's for lunch");
        question1.setType("text");
        Question question2 = new Question();
        question2.setName("How many");
        question2.setType("number");

        questionRepository.save(question1);
        questionRepository.save(question2);
        System.out.println(questionRepository.findAll());

    }
}
