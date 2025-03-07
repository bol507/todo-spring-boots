package com.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.controller.dto.TodoDto;
import com.todo.repository.TodoRepository;
import com.todo.repository.entity.TodoEntity;
import com.todo.service.TodoService;
import com.todo.service.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    
    private final TodoRepository todoRepository;

    @Override
    public List<TodoDto> listAll() {
        List<TodoEntity> todos = todoRepository.findByCompleted(false);
        return todos.stream()
            .map(e -> TodoMapper.toDto(e))
            .toList();
    }

    @Override
    public void create(TodoDto todo) {
        TodoEntity entity = TodoMapper.toEntity(todo, new TodoEntity());
        todoRepository.save(entity);
    }
}
