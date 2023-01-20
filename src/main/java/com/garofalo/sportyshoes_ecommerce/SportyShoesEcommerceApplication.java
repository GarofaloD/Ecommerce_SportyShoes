package com.garofalo.sportyshoes_ecommerce;

import com.garofalo.sportyshoes_ecommerce.entity.OrderEntity;
import com.garofalo.sportyshoes_ecommerce.entity.OrderProduct;
import com.garofalo.sportyshoes_ecommerce.entity.ProductEntity;
import com.garofalo.sportyshoes_ecommerce.service.OrderService;
import com.garofalo.sportyshoes_ecommerce.service.ProductService;
import com.garofalo.sportyshoes_ecommerce.*;

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
public class SportyShoesEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportyShoesEcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner1(ProductService productService, OrderService orderService) {
        return args -> {
            productService.addProduct(new ProductEntity("Nike shoes", 200.00, "Nike running shoes"));
            productService.addProduct(new ProductEntity( "Reebok Hat", 20.00, "Reebok Sports Hat"));
            productService.addProduct(new ProductEntity("UnderArmour Shirt", 80.00, "UnderArmour Gym Shirt"));
            productService.addProduct(new ProductEntity("Polo Hat", 50.00, "Polo Golf Hat"));
            productService.addProduct(new ProductEntity("Puma Shoes", 100.00, "Puma Basketball shoes"));
            productService.addProduct(new ProductEntity("Adidas Shorts", 30.00, "Adidas Gym Shorts"));
            productService.addProduct(new ProductEntity("Nike Sweater", 60.00, "Nike Casual Sweater"));






        };
    }




}
