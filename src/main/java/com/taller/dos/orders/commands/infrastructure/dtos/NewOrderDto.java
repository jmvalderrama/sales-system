package com.taller.dos.orders.commands.infrastructure.dtos;

import com.taller.dos.products.commands.infrastructure.dto.NewProductDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class NewOrderDto {

    @NotNull(message = "Debes añadir por lo menos un producto.")
    @Size(min = 1, message = "Debes añadir por lo menos un producto.")
    private List<NewProductDto> products;

    private Float amount;

    private Float tax;

    private Float freight;

    private Float totalAmount;
}
