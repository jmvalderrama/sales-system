package com.taller.dos.products.commands.infrastructure.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateProductDto {
    @NotNull(message = "Debes indicar el código del producto.")
    @NotBlank(message = "Debes indicar el código del producto.")
    private String productCode;

    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 100, message = "{validation.name.size.too_long}")
    private String description;

    @Min(value = 1)
    private Integer quantity;

    @Min(value = 1)
    @NotNull(message = "Debes indicar el precio del producto.")
    private Float unityPrice;
}
