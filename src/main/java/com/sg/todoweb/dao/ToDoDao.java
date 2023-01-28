package com.sg.todoweb.dao;

import java.util.List;

import com.sg.todoweb.entity.ToDo;

public interface ToDoDao {

    ToDo getToDo(int id);

    List<ToDo> getAllToDos();

    ToDo addToDo(ToDo todo);

    void updateToDo(ToDo todo);
    
    void removeToDo(int id);
}
