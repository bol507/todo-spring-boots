package com.todo.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductItem{

    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;

}
