package com.taller.dos.products.commands.domain;

import com.taller.dos.products.commons.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCommandRepository extends CrudRepository<ProductEntity, String> {
    Optional<ProductEntity> findByProductCode(String productCode);

}
