package com.taller.dos.products.commands.domain;

import com.taller.dos.products.commands.infrastructure.dto.NewProductDto;
import com.taller.dos.products.commands.infrastructure.dto.UpdateProductDto;

public interface ProductCommandService {
    /**
     * Método para registrar un nuevo producto.
     * @param productDto {@link NewProductDto}
     */
    void addProduct(NewProductDto productDto) throws Exception;
    void updateProduct(UpdateProductDto dto, String productCode) throws Exception;
    void deleteProduct(String productCode) throws Exception;
}
