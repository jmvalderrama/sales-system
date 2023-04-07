package com.taller.dos.products.queries.domain;

import com.taller.dos.products.queries.infrastructure.dto.ProductPresentationDto;
import io.reactivex.rxjava3.core.Maybe;

import java.util.List;

public interface ProductQueryService {
    Maybe<List<ProductPresentationDto>> findAllProducts() throws Exception;
}
