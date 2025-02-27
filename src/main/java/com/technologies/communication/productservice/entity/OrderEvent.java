package com.technologies.communication.productservice.entity;


import lombok.*;

/**
 * @author : El-Merjani Mohamed
 * Date : 2/27/2025
 */
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class OrderEvent {
    private Long id;
    private Long productId;
    private int quantity;
}
