package com.narainox.ecommercebackendapplication.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wishlists")
@Entity
@Data
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "wishlist_sequence"
    )
    @SequenceGenerator(
            name = "wishlist_sequence",
            sequenceName = "wishlist_sequence",
            allocationSize = 1
    )
    private Integer id;
    @OneToOne(targetEntity = User.class,fetch =FetchType.EAGER)
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "created_date")
    private LocalDateTime createdAt;
}
