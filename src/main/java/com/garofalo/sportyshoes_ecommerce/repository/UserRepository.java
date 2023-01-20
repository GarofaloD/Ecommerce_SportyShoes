package com.garofalo.sportyshoes_ecommerce.repository;

import com.garofalo.sportyshoes_ecommerce.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
