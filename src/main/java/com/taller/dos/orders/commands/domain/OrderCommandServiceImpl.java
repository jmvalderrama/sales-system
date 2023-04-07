package com.taller.dos.orders.commands.domain;

import com.taller.dos.orders.commands.infrastructure.dtos.NewOrderDto;
import com.taller.dos.orders.commands.infrastructure.mappers.NewOrderMapper;
import com.taller.dos.orders.commons.OrderEntity;
import com.taller.dos.orders.commons.OrderStatus;
import com.taller.dos.products.commands.infrastructure.mapper.NewProductMapper;
import com.taller.dos.products.commons.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {
    @Autowired
    OrderCommandRepository orderCommandRepository;
    @Autowired
    NewOrderMapper newOrderMapper;
    @Autowired
    NewProductMapper newProductMapper;

    @Override
    @Transactional
    public void createOrder(NewOrderDto dto) throws Exception {
        OrderEntity order = newOrderMapper.dtoToEntity(dto);
        Float amount = 0.0F;

        List<ProductEntity> products = newProductMapper.dtosToEntites(dto.getProducts());
        order.setProducts(products);

        for (int i = 0; i < order.getProducts().size(); i++) {
            amount += order.getProducts().get(i).getUnityPrice();
        }
        order.setAmount(amount);

        Float newFreight = order.getAmount() > 100000.0F ? 0.0F : 10000.0F;
        Float newTax = order.getAmount() * 0.19F;
        Float totalAmount = order.getAmount() + newFreight + newTax;

        order.setTotalAmount(totalAmount);
        order.setTax(newTax);
        order.setFreight(newFreight);
        order.setStatus(OrderStatus.IN_PROGRESS);

        orderCommandRepository.save(order);
    }

    @Override
    public void sendOrder(String id) throws Exception {

    }
}
