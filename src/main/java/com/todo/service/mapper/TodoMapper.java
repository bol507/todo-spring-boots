package com.todo.service.mapper;

import com.todo.controller.dto.TodoDto;
import com.todo.repository.entity.TodoEntity;

public class TodoMapper {

    private TodoMapper() {
    }
    
    public static TodoDto toDto(TodoEntity entity) {
        TodoDto dto = new TodoDto();
        dto.setId(entity.getId());
        dto.setTask(entity.getTask());
        dto.setDueDate(entity.getDueDate());
        dto.setDateCreated(entity.getDateCreated());
        dto.setCompleted(entity.isCompleted());
        dto.setArchived(entity.isArchived());
        dto.setReminder(entity.isReminder());
        return dto;
    }

    public static TodoEntity fromDtoToEntity(TodoDto dto, TodoEntity entity) {
        entity.setTask(dto.getTask());
        entity.setDueDate(dto.getDueDate());
        entity.setDateCreated(dto.getDateCreated());
        entity.setCompleted(dto.isCompleted());
        entity.setArchived(dto.isArchived());
        entity.setReminder(dto.isReminder());
        return entity;
    }

}
