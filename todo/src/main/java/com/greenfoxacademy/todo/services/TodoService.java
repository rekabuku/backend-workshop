package com.greenfoxacademy.todo.services;

import com.greenfoxacademy.todo.models.Todo;

public interface TodoService {

    public Todo findById( long id);

    public Iterable<Todo> findAll();

    public Todo save(Todo todo);

    public void delete(Todo todo);

    public Todo findByTitle(String title);
}
