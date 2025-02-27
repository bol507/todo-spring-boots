package com.todo.controller.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductItem{

    private UUID id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private boolean active;
    private Integer storage;

}
