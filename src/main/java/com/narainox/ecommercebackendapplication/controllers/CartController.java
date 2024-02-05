package com.narainox.ecommercebackendapplication.controllers;

import com.narainox.ecommercebackendapplication.dto.AddToCartDto;
import com.narainox.ecommercebackendapplication.models.Cart;
import com.narainox.ecommercebackendapplication.payloads.APIResponse;
import com.narainox.ecommercebackendapplication.security.JwtTokenHelper;
import com.narainox.ecommercebackendapplication.services.CartService;
import com.narainox.ecommercebackendapplication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private ProductService productService;

    @PostMapping("/api/v1/")
    public ResponseEntity<APIResponse> addToCart(
            @RequestBody AddToCartDto addToCartDto,
            @RequestParam("token") String token
            )
    {
        APIResponse apiResponse=new APIResponse();
        try{
            String user = jwtTokenHelper.getUsernameFromToken("Bearer " + token);
            Cart cart=cartService.addToCartDto(addToCartDto,user);
            apiResponse.setData(cart);
            apiResponse.setMessage("Product is added successfully.");
            return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}