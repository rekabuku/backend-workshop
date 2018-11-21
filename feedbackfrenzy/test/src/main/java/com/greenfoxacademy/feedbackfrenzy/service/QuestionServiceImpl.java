package com.greenfoxacademy.feedbackfrenzy.service;

import com.greenfoxacademy.feedbackfrenzy.model.Question;
import com.greenfoxacademy.feedbackfrenzy.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(long id) {
        return questionRepository.findById(id).get();
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }

    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

}
