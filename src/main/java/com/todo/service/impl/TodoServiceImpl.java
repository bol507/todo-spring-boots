package com.todo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.todo.controller.dto.TodoDto;
import com.todo.repository.TodoRepository;
import com.todo.repository.entity.TodoEntity;
import com.todo.service.TodoService;
import com.todo.service.mapper.TodoMapper;

import jakarta.persistence.EntityNotFoundException;
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

    @Override
    public void update(UUID id, TodoDto todo) {
        Optional <TodoEntity> optEntity = todoRepository.findById(id);
        if(optEntity.isEmpty()){
            throw new EntityNotFoundException("Todo entity not found");
        }
        TodoEntity entity = optEntity.get();
        TodoMapper.toEntity(todo, entity);
        todoRepository.save(entity);
    }
}
