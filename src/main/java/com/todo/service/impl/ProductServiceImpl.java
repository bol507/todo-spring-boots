package com.todo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.todo.controller.dto.ProductItem;
import com.todo.exception.EntityNotFoundException;
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

    @PostConstruct
    public void init() {
        // Imprimir las variables de entorno para verificar su carga
        System.out.println("DB_URL: " + System.getenv("DB_URL"));
        System.out.println("DB_USER: " + System.getenv("DB_USER"));
        System.out.println("DB_PASS: " + System.getenv("DB_PASS"));
    }
    
    @Override
    public List<ProductItem> list() {
        List<ProductEntity> entities = productRepository.findByActive(true);
        return entities.stream()
                .map(e -> ProductMapper.toDto(e))
                .toList();
    }

    @Override
    public void create(ProductItem product) {
        ProductEntity entity = ProductMapper.fromDtoEntity(product, new ProductEntity());
        entity.setActive(true);
        productRepository.save(entity);
    }

    @Override
    public void update(UUID id, ProductItem product) {
        Optional<ProductEntity> opt = productRepository.findById(id);
        if(opt.isEmpty()){
            throw new EntityNotFoundException("Entity not found");
        }
        if(Boolean.FALSE.equals(opt.get().isActive())){
            throw new EntityNotFoundException("Product "+id+" was previously deleted");
        }   
        ProductEntity entity = opt.get();
        ProductMapper.fromDtoEntity(product, entity);
        productRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        
        Optional<ProductEntity> opt = productRepository.findByIdAndActive(id,true);
            
        if(opt.isEmpty()){
            throw new EntityNotFoundException("No entity found with id "+id+" to delete");
        }
        ProductEntity entity = opt.get();
        entity.setActive(false);
        productRepository.save(entity);
    }

}
