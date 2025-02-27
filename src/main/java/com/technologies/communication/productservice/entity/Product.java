package com.technologies.communication.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author : El-Merjani Mohamed
 * Date : 2/26/2025
 */
@Entity @Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @Column(name = "available_stock")
    private int availableStock;


}
