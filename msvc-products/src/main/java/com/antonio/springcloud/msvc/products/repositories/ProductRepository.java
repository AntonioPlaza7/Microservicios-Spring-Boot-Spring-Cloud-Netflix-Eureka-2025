package com.antonio.springcloud.msvc.products.repositories;

import org.springframework.data.repository.CrudRepository;

import com.antonio.libs.msvc.commons.entities.Product;


public interface ProductRepository extends CrudRepository<Product, Long> {

}
