package com.br.CadastroDeProdutos.controller;


import com.br.CadastroDeProdutos.dto.ProductDto;
import com.br.CadastroDeProdutos.model.Product;
import com.br.CadastroDeProdutos.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
@CrossOrigin(origins = "*")
public class ProductController {


    private final ProductService productServices;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productServices.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(productServices.findById(id));


    }

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productServices.create(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);

    }

    @PutMapping(value = "/update/{id}", produces = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody ProductDto productDto) throws InvocationTargetException, IllegalAccessException {
        return new ResponseEntity<>(productServices.update(id, productDto), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}