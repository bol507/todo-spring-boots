package com.todo.repository.entity;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "todos")
@Getter
@Setter
public class TodoEntity extends AbstractEntity {

    @Column(name = "task", nullable = false)
    private String task;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Column(name = "is_completed")
    private boolean completed;

    @Column(name = "is_archived")
    private boolean archived;

    @Column(name = "is_reminder")
    private boolean reminder;

}
