package com.narainox.ecommercebackendapplication.services;

import com.narainox.ecommercebackendapplication.dto.AddToCartDto;
import com.narainox.ecommercebackendapplication.models.Cart;

public interface CartService  {
    Cart addToCartDto(AddToCartDto addToCartDto, String user);
}