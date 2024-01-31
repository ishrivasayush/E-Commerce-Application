package com.narainox.ecommercebackendapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonPageRequest {
    private Integer pageNo;
    private Integer pageSize;
    private String sortBy;
    private String sortDir;
}
