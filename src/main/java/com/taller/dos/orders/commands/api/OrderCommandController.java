package com.taller.dos.orders.commands.api;

import com.taller.dos.orders.commands.domain.OrderCommandService;
import com.taller.dos.orders.commands.infrastructure.dtos.NewOrderDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderCommandController {
    @Autowired
    OrderCommandService orderCommandService;

    @PostMapping
    public ResponseEntity<?> createOrder(@Valid @RequestBody NewOrderDto body, BindingResult result) {
        try {
            Map<String, Object> response = new HashMap<>();
            if (result.hasErrors()) {
                List<String> errorsList = result.getFieldErrors().stream()
                        .map(err -> "El campo '" + err.getField() + "' tiene la siguiente restricción: " + err.getDefaultMessage())
                        .toList();
                response.put("errors", errorsList);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            orderCommandService.createOrder(body);
            return new ResponseEntity<>("Pedido registrado con éxito.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
