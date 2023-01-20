package com.garofalo.sportyshoes_ecommerce.controller;

import com.garofalo.sportyshoes_ecommerce.entity.ProductEntity;
import com.garofalo.sportyshoes_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping("/allproducts")
    public List<ProductEntity> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping("/product/{id}")
    public ProductEntity getProductById(@PathVariable long id){
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public void addProduct(@RequestBody ProductEntity productEntity){
        productService.addProduct(productEntity);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/product/{id}")
    public void updateProduct(@PathVariable long id, ProductEntity productEntity){
        productService.updateProduct(id, productEntity);
    }


    @RequestMapping(method = RequestMethod.DELETE, value="/product/{id}")
    public void deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }


}
