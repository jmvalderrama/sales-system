package com.taller.dos.products.queries.domain;

import com.taller.dos.products.commons.ProductEntity;
import com.taller.dos.products.queries.infrastructure.dto.ProductPresentationDto;
import com.taller.dos.products.queries.infrastructure.mapper.ProductPresentationMapper;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    @Autowired
    private ProductPresentationMapper mapper;
    @Autowired
    private ProductQueryRepository queryRepository;

    @Override
    public Maybe<List<ProductPresentationDto>> findAllProducts() {
        return Maybe.just(queryRepository.findAll())
                .map(productEntities -> mapper.entitiesToDtos((List<ProductEntity>) productEntities))
                .switchIfEmpty(Maybe.error(new Exception("No hay productos disponibles.")));
    }
}
