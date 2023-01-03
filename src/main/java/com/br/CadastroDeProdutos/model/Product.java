package com.br.CadastroDeProdutos.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

@Data
@Entity
@Table(name = "tb_produto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRODUTO")
    private String name;
    @Column(name = "VALOR")
    private Double price;
}
