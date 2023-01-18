package com.garofalo.sportyshoes_ecommerce.repository;

import com.garofalo.sportyshoes_ecommerce.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
