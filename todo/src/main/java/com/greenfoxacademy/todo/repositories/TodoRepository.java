package com.greenfoxacademy.todo.repositories;


import com.greenfoxacademy.todo.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Todo findByTitle(String title);
}
