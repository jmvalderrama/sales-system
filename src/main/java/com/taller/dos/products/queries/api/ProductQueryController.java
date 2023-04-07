package com.taller.dos.products.queries.api;

import com.taller.dos.products.queries.domain.ProductQueryService;
import io.reactivex.rxjava3.core.Maybe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/products")
public class ProductQueryController {
    @Autowired
    private ProductQueryService productQueryService;

    @GetMapping
    public Maybe<ResponseEntity<?>> findAll() throws Exception {
        return productQueryService.findAllProducts()
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK));
    }
}
