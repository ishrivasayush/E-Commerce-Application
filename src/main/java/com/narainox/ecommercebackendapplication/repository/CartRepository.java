package com.narainox.ecommercebackendapplication.repository;

import com.narainox.ecommercebackendapplication.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
