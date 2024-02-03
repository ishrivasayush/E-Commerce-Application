package com.narainox.ecommercebackendapplication.controllers;

import com.narainox.ecommercebackendapplication.models.Product;
import com.narainox.ecommercebackendapplication.models.User;
import com.narainox.ecommercebackendapplication.payloads.APIResponse;
import com.narainox.ecommercebackendapplication.security.JwtTokenHelper;
import com.narainox.ecommercebackendapplication.services.ProductService;
import com.narainox.ecommercebackendapplication.services.UserService;
import com.narainox.ecommercebackendapplication.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @PostMapping("/add")
    public ResponseEntity<APIResponse> addToWishWishlist(
            @RequestBody Product product,
            @RequestParam String token
            )
    {
        String username = jwtTokenHelper.getUsernameFromToken(token);
        User user = userService.getUser(username);
        return null;
    }
}
