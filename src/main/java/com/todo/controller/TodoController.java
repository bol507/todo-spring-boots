package com.todo.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.controller.dto.TodoDto;
import com.todo.service.TodoService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoDto>> listAll() {
        try {
            List<TodoDto> todos = todoService.listAll();
            if(todos.isEmpty()){
                return ResponseEntity.status(404).build();
            }

            return ResponseEntity.ok(todos);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createTodo(@RequestBody TodoDto todo){
        try{
            todoService.create(todo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
        
    }

}
