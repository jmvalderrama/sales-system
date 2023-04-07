package com.taller.dos.products.queries.infrastructure.mapper;

import com.taller.dos.products.commons.ProductEntity;
import com.taller.dos.products.queries.infrastructure.dto.ProductPresentationDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductPresentationMapper {
    List<ProductPresentationDto> entitiesToDtos(List<ProductEntity> entities);
}
