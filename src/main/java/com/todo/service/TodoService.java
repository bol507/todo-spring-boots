package com.todo.service;

import java.util.List;

import com.todo.controller.dto.TodoDto;

public interface TodoService {

    List<TodoDto> listAll();
    void create(TodoDto todo);
}
