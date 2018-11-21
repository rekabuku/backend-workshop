package com.greenfoxacademy.feedbackfrenzy.repository;

import com.greenfoxacademy.feedbackfrenzy.model.QuestionGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionGroupRepository extends CrudRepository<QuestionGroup, Long> {
    List<QuestionGroup> findAll();
}
