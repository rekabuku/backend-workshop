package com.greenfoxacademy.todo.repositories;

import com.greenfoxacademy.todo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
