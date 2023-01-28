package com.sg.todoweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sg.todoweb.dao.ToDoDao;
import com.sg.todoweb.entity.ToDo;

@Controller
public class MainController {

    @Autowired
    ToDoDao todoDao;

    @GetMapping("/")
    public String index(Model model) {
        List<ToDo> todos = todoDao.getAllToDos();

        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/addToDo")
    public String addToDo(ToDo todo) {
        todo.setFinished(false);
        todoDao.addToDo(todo);
        return "redirect:/";
    }

    @GetMapping("/toggleToDo")
    public String toggleTodo(int id) {
        ToDo todo = todoDao.getToDo(id);
        todo.setFinished(!todo.isFinished());
        todoDao.updateToDo(todo);
        return "redirect:/";
    }

    @GetMapping("/deleteToDo")
    public String deleteTodo(int id) {
        todoDao.removeToDo(id);
        return "redirect:/";
    }
}
