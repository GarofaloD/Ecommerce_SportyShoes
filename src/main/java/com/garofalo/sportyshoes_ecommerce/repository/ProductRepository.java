package com.garofalo.sportyshoes_ecommerce.repository;

import com.garofalo.sportyshoes_ecommerce.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
