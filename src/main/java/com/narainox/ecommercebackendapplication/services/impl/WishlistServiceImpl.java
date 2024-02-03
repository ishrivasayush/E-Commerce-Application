package com.narainox.ecommercebackendapplication.services.impl;

import com.narainox.ecommercebackendapplication.models.Wishlist;
import com.narainox.ecommercebackendapplication.repository.WishlistRepository;
import com.narainox.ecommercebackendapplication.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;


}
