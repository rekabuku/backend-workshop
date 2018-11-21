package com.greenfoxacademy.feedbackfrenzy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class QuestionGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @OneToMany(cascade = CascadeType.PERSIST)
  private List<Question> questions;

}
