package com.greenfoxacademy.feedbackfrenzy.service;

import com.greenfoxacademy.feedbackfrenzy.model.QuestionGroup;
import com.greenfoxacademy.feedbackfrenzy.repository.QuestionGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionGroupServiceImpl implements QuestionGroupService{
    private QuestionGroupRepository questionGroupRepository;

    @Autowired
    public QuestionGroupServiceImpl(QuestionGroupRepository questionGroupRepository) {
        this.questionGroupRepository = questionGroupRepository;
    }

    @Override
    public List<QuestionGroup> getAllQuestionGroups() {
        return questionGroupRepository.findAll();
    }

    @Override
    public QuestionGroup getById(long id) {
        return questionGroupRepository.findById(id).get();
    }

    @Override
    public void save(QuestionGroup questionGroup) {
        questionGroupRepository.save(questionGroup);
    }

    @Override
    public void delete(QuestionGroup questionGroup) {
        questionGroupRepository.delete(questionGroup);
    }

    @Override
    public Iterable<QuestionGroup> findAll() {
        return questionGroupRepository.findAll();
    }


    @Override
    public void deleteById(Long id) {
        questionGroupRepository.deleteById(id);
    }
}
