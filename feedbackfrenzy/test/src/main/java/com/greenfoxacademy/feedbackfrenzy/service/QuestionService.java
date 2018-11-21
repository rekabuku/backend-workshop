package com.greenfoxacademy.feedbackfrenzy.service;

import com.greenfoxacademy.feedbackfrenzy.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();

    Question getById(long id);

    void save(Question question);

    void delete(Question question);

    public Iterable<Question> findAll();

    public void deleteById(Long id);
}
