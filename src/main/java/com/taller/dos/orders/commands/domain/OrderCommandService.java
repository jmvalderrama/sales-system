package com.taller.dos.orders.commands.domain;

import com.taller.dos.orders.commands.infrastructure.dtos.NewOrderDto;

public interface OrderCommandService {
    void createOrder(NewOrderDto dto) throws Exception;
    void sendOrder(String id) throws Exception;
}
