package com.taller.dos.products.commands.infrastructure.mapper;

import com.taller.dos.products.commands.infrastructure.dto.NewProductDto;
import com.taller.dos.products.commons.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewProductMapper {
    ProductEntity dtoToEntity(NewProductDto dto);
    List<ProductEntity> dtosToEntites(List<NewProductDto> dtos);
}
