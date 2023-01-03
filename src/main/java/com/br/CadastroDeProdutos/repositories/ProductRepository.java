package com.br.CadastroDeProdutos.repositories;

import com.br.CadastroDeProdutos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
