package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.repositories.TodoRepository;
import com.greenfoxacademy.todo.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {
    private TodoServiceImpl todoServiceImpl;

    @Autowired
    public TodoController(TodoServiceImpl todoServiceImpl) {
        this.todoServiceImpl = todoServiceImpl;
    }

    public TodoController(TodoRepository todoRepository) {
        this.todoServiceImpl = todoServiceImpl;
    }

    @GetMapping("/todo")
    public String list(Model model) {
        model.addAttribute("todos", todoServiceImpl.findAll());
        return "todolist";
    }


    @RequestMapping(value = {"/todo/list"})
    public String list(@RequestParam("isActive") Boolean done, Model model) {
        model.addAttribute("todos", todoServiceImpl.findAll());
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
        todoServiceImpl.save(newTodo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/{id}/edit")
    public String edit(@PathVariable(value = "id") Long id, Model model) {
        Todo todo = todoServiceImpl.findById(id);
        model.addAttribute("todo", todo);
        return "edit";
    }

    @PostMapping("/todo/{id}/edit")
    public String editTodo(@PathVariable(value = "id") Long id, Model model, Todo todo) {
        model.addAttribute("todo", todo);
        todoServiceImpl.save(todo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/{id}/delete")
    public String delete(@PathVariable(value = "id") Long id) {
        Todo todo = todoServiceImpl.findById(id);
        todoServiceImpl.delete(todo);
        return "redirect:/todo";
    }

    @PostMapping("/todo/{id}/delete")
    public String delete(@PathVariable(value = "id") Long id, Todo todo) {
        todoServiceImpl.delete(todo);
        return "redirect:/todo";
    }

    @GetMapping("/todo/search")
    public String list(String search, Model model) {
        model.addAttribute("todos", todoServiceImpl.findByTitle(search));
        return "search";
    }

    @GetMapping("/api/list")
    @ResponseBody
    public Iterable<Todo> findTodos() {
        return todoServiceImpl.findAll();
    }

    @PostMapping("/api/save")
    @ResponseBody
    public Todo saveTodo(@RequestBody Todo todo) {
        todoServiceImpl.save(todo);
        return todo;
    }
}



