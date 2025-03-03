package com.todo.controller.dto;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {

    private UUID id;
    private String task;
    private LocalDate dueDate;
    private LocalDate dateCreated;
    private boolean completed;
    private boolean archived;
    private boolean reminder;

}
