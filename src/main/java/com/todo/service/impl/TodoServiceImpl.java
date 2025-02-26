package com.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.controller.dtro.TodoDto;
import com.todo.repository.TodoRepository;
import com.todo.service.TodoService;
import com.todo.service.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    
    private final TodoRepository todoRepository;

    @Override
    public List<TodoDto> listAll() {
        return todoRepository.findAll()
            .stream()
            .map(e -> TodoMapper.ToDto(e)).toList();
    }
}
