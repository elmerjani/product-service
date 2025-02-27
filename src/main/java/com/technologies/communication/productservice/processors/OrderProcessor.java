package com.technologies.communication.productservice.processors;

import com.technologies.communication.productservice.models.OrderEvent;
import com.technologies.communication.productservice.models.ProductEvent;
import com.technologies.communication.productservice.models.ProductStatus;
import com.technologies.communication.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * @author : El-Merjani Mohamed
 * Date : 2/27/2025
 */
@Configuration
public class OrderProcessor {

    private final ProductRepository productRepository;

    public OrderProcessor(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Bean
    public Function<OrderEvent, ProductEvent> processor() {

        return order -> {
            System.out.println(order);
            var  productOptional = productRepository.findById(order.getProductId());
            if(productOptional.isPresent()) {
                var product = productOptional.get();
                if(product.getAvailableStock() < order.getQuantity()) {
                    return new ProductEvent(product.getId(), order.getId(), ProductStatus.OUT_OF_STOCK);
                }
                else{
                    product.setAvailableStock(product.getAvailableStock() - order.getQuantity());
                    productRepository.save(product);
                    return new ProductEvent(product.getId(), order.getId(), ProductStatus.AVAILABLE);
                }
            }else{
                return null;
            }
        };
    }
}
