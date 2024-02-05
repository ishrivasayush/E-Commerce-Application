package com.narainox.ecommercebackendapplication.services;

import com.narainox.ecommercebackendapplication.dto.AddToCartDto;
import com.narainox.ecommercebackendapplication.models.Cart;
import com.narainox.ecommercebackendapplication.models.User;

public interface CartService  {
    Cart addToCartDto(AddToCartDto addToCartDto, User user) throws Exception;
}
