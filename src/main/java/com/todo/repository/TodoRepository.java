package com.todo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.repository.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, UUID> {

}
