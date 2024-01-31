package com.narainox.ecommercebackendapplication.services;

import com.narainox.ecommercebackendapplication.dto.CategoryDto;
import com.narainox.ecommercebackendapplication.dto.CommonPageRequest;
import com.narainox.ecommercebackendapplication.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto,Integer CategoryId)throws Exception;
    ProductDto updateProduct(ProductDto productDto,Integer productId)throws Exception;
    List<ProductDto> getProducts(CommonPageRequest commonPageRequest)throws Exception;
    void deleteProduct(Integer productId) throws Exception;
}
