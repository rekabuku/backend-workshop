package com.greenfoxacademy.feedbackfrenzy.controller;

import com.greenfoxacademy.feedbackfrenzy.model.Question;
import com.greenfoxacademy.feedbackfrenzy.service.QuestionGroupServiceImpl;
import com.greenfoxacademy.feedbackfrenzy.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "forms/groups/questions")
public class QuestionController {
    private QuestionServiceImpl questionServiceImpl;
    private QuestionGroupServiceImpl questionGroupServiceImpl;

    @Autowired
    public QuestionController(QuestionServiceImpl questionServiceImpl, QuestionGroupServiceImpl questionGroupServiceImpl) {
        this.questionServiceImpl = questionServiceImpl;
        this.questionGroupServiceImpl = questionGroupServiceImpl;
    }

    @GetMapping()
    public String getQuestionsPage(Model model) {
        model.addAttribute("questions", questionServiceImpl.findAll());
        return "questions";
    }

    @GetMapping("/{id}")
    public String getQuestionsPage(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("questions", questionServiceImpl.findAll());
        return "questions";
    }

    @PostMapping("/add")
    public String getNewQuestion(String name, String type) {
        if (name.isEmpty() || type.isEmpty()) {
            return "redirect:/forms/groups/questions";
        }
        Question newQuestion = new Question();
        newQuestion.setName(name);
        newQuestion.setType(type);
        questionServiceImpl.save(newQuestion);
        return "redirect:/forms/groups/questions/" + newQuestion.getId();
    }

    @PostMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable(value = "id") Long id) {
        Question question = questionServiceImpl.getById(id);
        questionServiceImpl.deleteById(id);
        return "redirect:/forms/groups/questions";
    }

    @GetMapping("/edit/{id}")
    public String getQuestionEdit(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("question", questionServiceImpl.getById(id));
        return "question-editor";
    }

    @PostMapping("/edit/{id}")
    public String postQuestionEdit(@PathVariable(value = "id") Long id, Model model, Question question, String name, String type) {
        if (name.isEmpty() || type.isEmpty()) {
            return "redirect:/forms/groups/questions/edit/{id}";
        }
        model.addAttribute("question", question);
        question = questionServiceImpl.getById(id);
        question.setName(name);
        question.setType(type);
        questionServiceImpl.save(question);
        return "redirect:/forms/groups/questions";
    }

    @PostMapping("/cancel/{id}")
    public String cancelEdition(@PathVariable(value = "id") Long id) {
        return "redirect:/forms/groups/questions";
    }
}
