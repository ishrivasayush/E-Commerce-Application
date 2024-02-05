package com.narainox.ecommercebackendapplication.services.impl;

import com.narainox.ecommercebackendapplication.dto.AddToCartDto;
import com.narainox.ecommercebackendapplication.dto.ProductDto;
import com.narainox.ecommercebackendapplication.models.Cart;
import com.narainox.ecommercebackendapplication.models.Product;
import com.narainox.ecommercebackendapplication.models.User;
import com.narainox.ecommercebackendapplication.repository.CartRepository;
import com.narainox.ecommercebackendapplication.services.CartService;
import com.narainox.ecommercebackendapplication.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService productService;

    @Override
    public Cart addToCartDto(AddToCartDto addToCartDto, User user) throws Exception{
        ProductDto product = productService.getProduct(addToCartDto.getProductId());
        Cart cart=new Cart();
        cart.setCraetedDate(new Date());
        cart.setProduct(modelMapper.map(product, Product.class));
        cart.setUser(user);
        return cartRepository.save(cart);
    }
}
