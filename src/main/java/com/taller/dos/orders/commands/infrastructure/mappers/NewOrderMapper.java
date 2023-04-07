package com.taller.dos.orders.commands.infrastructure.mappers;

import com.taller.dos.orders.commands.infrastructure.dtos.NewOrderDto;
import com.taller.dos.orders.commons.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewOrderMapper {
    OrderEntity dtoToEntity(NewOrderDto dto);
}
