package com.garofalo.sportyshoes_ecommerce.service;

import com.garofalo.sportyshoes_ecommerce.entity.ProductEntity;
import com.garofalo.sportyshoes_ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    public ProductEntity getProduct(long id){
        return productRepository.findById(id).get();
    }

    public void addProduct(ProductEntity productEntity){
        productRepository.save(productEntity);
    }

    public void updateProduct(long id, ProductEntity productEntity){
        if(productRepository.findById(id).isPresent()){

            ProductEntity oldProductEntity = productRepository.findById(id).get();

            oldProductEntity.setProductName(productEntity.getProductName());
            oldProductEntity.setPDescription(productEntity.getDescription());

            productRepository.save(oldProductEntity);
        }
    }

}
