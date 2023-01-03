package com.br.CadastroDeProdutos.services;

import com.br.CadastroDeProdutos.dto.ProductDto;
import com.br.CadastroDeProdutos.model.Product;
import com.br.CadastroDeProdutos.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {


    private final ProductRepository productRepository;


    public List<Product> findAll() {

        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();

    }

    public Product create(Product product) {
        return productRepository.save(product);

    }


    public Product update(Long id, ProductDto productDto) throws InvocationTargetException, IllegalAccessException {
        Product products = findById(id);
        if (products != null) {
            BeanUtils.copyProperties(products, products);
            return create(products);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        productRepository.deleteById(id);

    }

}


