package com.debug.crud.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debug.crud.shopping.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
