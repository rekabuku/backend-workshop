package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.repositories.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {
    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todo")
    public String list(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todolist";
    }


    @RequestMapping(value = {"/todo/list"})
    public String list(@RequestParam("isActive") Boolean done, Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        model.addAttribute("done", done);
        return "activetodo";
    }

    @GetMapping("/todo/add")
    public String addTodo() {
        return "add";
    }

    @PostMapping("/todo/add")
    public String getName(@RequestParam("todo") String todo) {
        if (todo.isEmpty()) {
            return "add";
        }
        Todo newTodo = new Todo();
        newTodo.setTitle(todo);
        todoRepository.save(newTodo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/{id}/edit")
    public String edit(@PathVariable(value = "id") Long id, Model model) {
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "edit";
    }

    @PostMapping("/todo/{id}/edit")
    public String editTodo(@PathVariable(value = "id") Long id, Model model, Todo todo) {
        model.addAttribute("todo", todo);
        todoRepository.save(todo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/{id}/delete")
    public String delete(@PathVariable(value = "id") Long id) {
        Todo todo = todoRepository.findById(id).get();
        todoRepository.delete(todo);
        return "redirect:/todo";
    }

    @PostMapping("/todo/{id}/delete")
    public String delete(@PathVariable(value = "id") Long id, Todo todo) {
        todoRepository.delete(todo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/search")
    public String list(String search, Model model) {
        model.addAttribute("todos", todoRepository.findByTitle(search));
        return "search";
    }

    @GetMapping("/api/list")
    @ResponseBody
    public Iterable<Todo> findTodos() {
        return todoRepository.findAll();
    }

    @PostMapping("/api/save")
    @ResponseBody
    public Todo saveTodo(@RequestBody Todo todo) {
        todoRepository.save(todo);
        return todo;
    }
}



