package com.taller.dos.products.commons;

import com.taller.dos.orders.commons.OrderEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.MERGE)
    private List<OrderEntity> orders = new ArrayList<>();

    @Column(name = "product_code", unique = true)
    private String productCode;

    @Column(length = 100)
    private String description;

    private Integer quantity;

    @Column(name = "unity_price")
    private Float unityPrice;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

