package com.narainox.ecommercebackendapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    @NotBlank(message = "categoryId required parameter")
    private Integer categoryId;
    @NotBlank(message = "categoryName required parameter")
    private String categoryName;
    @NotBlank(message = "description required parameter")
    private String description;
    @NotBlank(message = "imageUrl required parameter")
    private String imageUrl;

    private LocalDateTime created_At;

    private LocalDateTime updated_At;
}
