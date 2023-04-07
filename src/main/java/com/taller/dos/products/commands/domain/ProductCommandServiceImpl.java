package com.taller.dos.products.commands.domain;

import com.taller.dos.products.commands.infrastructure.dto.NewProductDto;
import com.taller.dos.products.commands.infrastructure.dto.UpdateProductDto;
import com.taller.dos.products.commands.infrastructure.exceptions.ProductNotFoundException;
import com.taller.dos.products.commands.infrastructure.mapper.NewProductMapper;
import com.taller.dos.products.commands.infrastructure.mapper.UpdateProductMapper;
import com.taller.dos.products.commons.ProductEntity;
import com.taller.dos.products.commands.infrastructure.exceptions.ProductDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements ProductCommandService{
    @Autowired
    ProductCommandRepository productCommandRepository;
    @Autowired
    NewProductMapper productMapper;
    @Autowired
    UpdateProductMapper updateProductMapper;

    @Override
    public void addProduct(NewProductDto productDto) throws ProductDuplicatedException {
        productCommandRepository.findByProductCode(productDto.getProductCode())
                .ifPresent(e -> {
                    throw new ProductDuplicatedException("El producto que deseas ingresar ya existe.");
                });

        ProductEntity productEntity = productMapper.dtoToEntity(productDto);
        productCommandRepository.save(productEntity);
    }

    @Override
    public void updateProduct(UpdateProductDto productDto, String id) {
        productCommandRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("El producto que deseas actualizar no existe."));
        ProductEntity productEntity = updateProductMapper.dtoToEntity(productDto);
        productEntity.setId(id);
        productCommandRepository.save(productEntity);
    }

    @Override
    public void deleteProduct(String id) {
        productCommandRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("El producto que deseas eliminar no existe."));
        productCommandRepository.deleteById(id);

    }

}
