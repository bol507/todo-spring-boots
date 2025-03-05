package com.todo.service;

import java.util.List;
import java.util.UUID;

import com.todo.controller.dto.TodoDto;

public interface TodoService {

    List<TodoDto> listAll();
    void create(TodoDto todo);
    void update(UUID id, TodoDto todo);
}
