package com.technologies.communication.productservice.repository;

import com.technologies.communication.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : El-Merjani Mohamed
 * Date : 2/26/2025
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
