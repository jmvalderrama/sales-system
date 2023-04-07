package com.taller.dos.products.commands.api;

import com.taller.dos.products.commands.domain.ProductCommandService;
import com.taller.dos.products.commands.infrastructure.dto.NewProductDto;
import com.taller.dos.products.commands.infrastructure.dto.UpdateProductDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductCommandController {

    @Autowired
    ProductCommandService productCommandService;

    @PostMapping
    public ResponseEntity<?> addProduct(@Valid @RequestBody NewProductDto body, BindingResult result) {
        try {
            Map<String, Object> response = new HashMap<>();
            if (result.hasErrors()) {
                List<String> errorsList = result.getFieldErrors().stream()
                        .map(err -> "El campo '" + err.getField() + "' tiene la siguiente restricción: " + err.getDefaultMessage())
                        .toList();
                response.put("errors", errorsList);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            productCommandService.addProduct(body);
            return new ResponseEntity<>("Producto registrado con éxito.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody UpdateProductDto body, @PathVariable String id) {
        try {
            productCommandService.updateProduct(body, id);
            return new ResponseEntity<>("Producto actualizado con éxito.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        try {
            productCommandService.deleteProduct(id);
            return new ResponseEntity<>("Producto eliminado con éxito.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
