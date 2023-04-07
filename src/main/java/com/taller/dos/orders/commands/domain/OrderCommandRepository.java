package com.taller.dos.orders.commands.domain;

import com.taller.dos.orders.commons.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCommandRepository extends CrudRepository<OrderEntity, String> {
}
