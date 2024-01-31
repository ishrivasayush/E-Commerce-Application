package com.narainox.ecommercebackendapplication.services;

import com.narainox.ecommercebackendapplication.dto.CategoryDto;
import com.narainox.ecommercebackendapplication.dto.CommonPageRequest;
import com.narainox.ecommercebackendapplication.models.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto)throws Exception;
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId)throws Exception;
    CategoryDto getCategory(Integer categoryId)throws Exception;
    List<CategoryDto> getCategories(CommonPageRequest commonPageRequest)throws Exception;
    CategoryDto getCategoryByName(String categoryName)throws Exception;
}
