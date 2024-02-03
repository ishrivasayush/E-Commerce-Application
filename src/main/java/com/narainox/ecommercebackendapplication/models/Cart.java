package com.narainox.ecommercebackendapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carts")
@Entity
@Data
public class Cart {
    private Integer id;
    private Product product;
    private User user;
    private LocalDateTime createdAt;
    private Integer quantity;
}
