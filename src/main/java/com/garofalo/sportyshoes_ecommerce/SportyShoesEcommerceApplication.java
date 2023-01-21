package com.garofalo.sportyshoes_ecommerce;

import com.garofalo.sportyshoes_ecommerce.entity.OrderEntity;
import com.garofalo.sportyshoes_ecommerce.entity.OrderProduct;
import com.garofalo.sportyshoes_ecommerce.entity.ProductEntity;
import com.garofalo.sportyshoes_ecommerce.service.OrderService;
import com.garofalo.sportyshoes_ecommerce.service.ProductService;
import com.garofalo.sportyshoes_ecommerce.*;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.persistence.criteria.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import java.util.*;


import java.time.LocalDate;

@SpringBootApplication
@OpenAPIDefinition
public class SportyShoesEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportyShoesEcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.addProduct(new ProductEntity( "Nike Shoes", 120.00, "White Nike Shoes"));
            productService.addProduct(new ProductEntity("Reebok Hat", 50.00, "Black reebok hat"));

        };
    }

}
