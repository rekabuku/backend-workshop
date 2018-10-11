package com.greenfoxacademy.todo;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

    private TodoRepository todoRepository;

    public TodoApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Todo todo = new Todo();
        todo.setTitle("Drink coffee");
        Todo todo2 = new Todo();
        todo2.setTitle("Clean the bathroom");
        todo2.setUrgent(true);
        Todo todo3 = new Todo();
        todo3.setTitle("Buy milk");
        todo3.setDone(true);
        Todo todo4 = new Todo();
        todo4.setTitle("Pay the bills");
        todo4.setUrgent(true);
        todo4.setDone(true);
        Todo todo5 = new Todo();
        todo5.setTitle("Order pizza");
        Todo todo6 = new Todo();
        todo6.setTitle("Go to bed");

        todoRepository.save(todo);
        todoRepository.save(todo2);
        todoRepository.save(todo3);
        todoRepository.save(todo4);
        todoRepository.save(todo5);
        todoRepository.save(todo6);
        System.out.println(todoRepository.findAll());

    }
}
