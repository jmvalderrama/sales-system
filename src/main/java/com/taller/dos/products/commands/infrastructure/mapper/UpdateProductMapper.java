package com.taller.dos.products.commands.infrastructure.mapper;

import com.taller.dos.products.commands.infrastructure.dto.UpdateProductDto;
import com.taller.dos.products.commons.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateProductMapper {
    ProductEntity dtoToEntity(UpdateProductDto dto);
}
