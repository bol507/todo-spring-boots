package com.todo.service;

import java.util.List;
import java.util.UUID;

import com.todo.controller.dto.ProductItem;

public interface ProductService {

    List<ProductItem> list();
    void create(ProductItem product);
    void update(UUID id, ProductItem product);
    void delete(UUID id);

}
