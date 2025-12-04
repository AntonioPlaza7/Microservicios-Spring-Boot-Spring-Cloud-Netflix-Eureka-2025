package com.antonio.springcloud.msvc.products.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.antonio.libs.msvc.commons.entities.Product;
import com.antonio.springcloud.msvc.products.services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;




@RestController

public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);


    final private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> list(@RequestHeader(name = "massage-request", required = false) String message) {
        logger.info("Mensaje en el request: {}", message);
        logger.info("Ingresando al metodo del controller ProductController::list");
        return this.service.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> details(@PathVariable Long id) throws InterruptedException {

        logger.info("Ingresando al metodo del controller ProductController::details");

        if (id.equals(10L)) {
            // throw new IllegalStateException("Producto no encontrado");            
        }
        if (id.equals(7L)) {
            TimeUnit.SECONDS.sleep(3L);  
        }

        Optional<Product> produOptional = service.findById(id);

        if (produOptional.isPresent()) {
            return ResponseEntity.ok(produOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        logger.info("Ingresando metodo ProductController::create, creando: {}", product);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Product product) {
        logger.info("Ingresando metodo ProductController::update, actualizando: {}", product);

        Optional<Product> produOptional = service.findById(id);
        if (produOptional.isPresent()) {
            Product productDB = produOptional.orElseThrow();
            productDB.setName(product.getName());
            productDB.setPrice(product.getPrice());
            productDB.setCreateAt(product.getCreateAt());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {       
        Optional<Product> produOptional = service.findById(id);
        if (produOptional.isPresent()) {
            this.service.deleteById(id);
            logger.info("Ingresando metodo ProductController::delete, eliminado: {}", produOptional.get());
            
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
    
    
    
    
    

}
