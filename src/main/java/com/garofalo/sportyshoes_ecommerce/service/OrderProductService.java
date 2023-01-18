package com.garofalo.sportyshoes_ecommerce.service;

import com.garofalo.sportyshoes_ecommerce.entity.OrderProduct;
import com.garofalo.sportyshoes_ecommerce.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    @Autowired
    OrderProductRepository orderProductRepository;

    public OrderProduct createOrder(OrderProduct orderProduct){
        return orderProductRepository.save(orderProduct);
    }





}
