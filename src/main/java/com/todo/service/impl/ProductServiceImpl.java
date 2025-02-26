package com.todo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.todo.controller.dto.ProductItem;
import com.todo.exception.EntityNotFoundException;
import com.todo.exception.ProductNotFoundException;
import com.todo.repository.ProductRepository;
import com.todo.repository.entity.ProductEntity;
import com.todo.service.ProductService;
import com.todo.service.mapper.ProductMapper;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;   
    
    @Override
    public List<ProductItem> list() {
        return productRepository.findAll().stream()
                .map(e -> ProductMapper.toDto(e))
                .toList();
    }

    @Override
    public void create(ProductItem product) {
        ProductEntity entity = ProductMapper.fromDtoEntity(product, new ProductEntity());
        productRepository.save(entity);
    }

    @Override
    public void update(UUID id, ProductItem product) {
        Optional<ProductEntity> opt = productRepository.findById(id);
        if(opt.isEmpty()){
            throw new EntityNotFoundException("Entity not found");
        }
        ProductEntity entity = opt.get();
        ProductMapper.fromDtoEntity(product, entity);
        productRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
        Optional<ProductItem> opt = products.stream()
            .filter(e -> Objects.equals(e.getId(), id)).findAny();
        if(opt.isEmpty()){
            throw new RuntimeException("Prodcut not found");
        }
        ProductItem result = opt.get();
        products.remove(result);
    }

}
