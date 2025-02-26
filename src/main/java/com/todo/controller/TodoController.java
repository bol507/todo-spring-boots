package com.todo.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.controller.dtro.TodoDto;
import com.todo.service.TodoService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoDto>> listAll() {
        return ResponseEntity.ok(todoService.listAll());
    }
   

}
