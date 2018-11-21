package com.greenfoxacademy.feedbackfrenzy.service;

import com.greenfoxacademy.feedbackfrenzy.model.QuestionGroup;

import java.util.List;

public interface QuestionGroupService {
    List<QuestionGroup> getAllQuestionGroups();

    QuestionGroup getById(long id);

    void save(QuestionGroup questionGroup);

    void delete(QuestionGroup questionGroup);

    public Iterable<QuestionGroup> findAll();

    public void deleteById(Long id);

}
