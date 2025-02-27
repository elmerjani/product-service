package com.technologies.communication.productservice.models;

import lombok.*;

/**
 * @author : El-Merjani Mohamed
 * Date : 2/27/2025
 */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProductEvent {
    private Long id;
    private Long orderId;
    private ProductStatus status;
}
