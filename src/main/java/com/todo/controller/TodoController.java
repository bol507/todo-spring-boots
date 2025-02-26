package com.todo.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.controller.dtro.TodoDto;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> ListById(@PathVariable("id") UUID id){
        //TodoDto dto = todoService.listById(id);
        //Return ResponseEntity.ok(dto);
        return null;
    }

   

}
