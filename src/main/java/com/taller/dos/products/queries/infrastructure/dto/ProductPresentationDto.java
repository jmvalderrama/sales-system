package com.taller.dos.products.queries.infrastructure.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductPresentationDto {
    private String id;
    private String productCode;
    private String description;
    private Integer quantity;
    private Float unityPrice;
}