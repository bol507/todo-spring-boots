package com.todo.service.mapper;

import com.todo.controller.dto.ProductItem;
import com.todo.repository.entity.ProductEntity;

public class ProductMapper {

    private ProductMapper() {
    }

    public static ProductItem toDto(ProductEntity entity) {
        ProductItem dto = new ProductItem();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        return dto;
    }

    public static ProductEntity fromDtoEntity(ProductItem dto, ProductEntity entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        return entity;
    }

}
