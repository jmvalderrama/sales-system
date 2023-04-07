package com.taller.dos.products.queries.domain;

import com.taller.dos.products.commons.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductQueryRepository extends CrudRepository<ProductEntity, String> {
}
