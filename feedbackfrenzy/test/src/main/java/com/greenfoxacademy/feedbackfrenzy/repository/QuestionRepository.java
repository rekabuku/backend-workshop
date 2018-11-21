package com.greenfoxacademy.feedbackfrenzy.repository;

import com.greenfoxacademy.feedbackfrenzy.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findAll();
}
