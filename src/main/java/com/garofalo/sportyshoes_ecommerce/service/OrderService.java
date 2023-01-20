package com.garofalo.sportyshoes_ecommerce.service;

import com.garofalo.sportyshoes_ecommerce.entity.OrderEntity;
import com.garofalo.sportyshoes_ecommerce.entity.OrderProduct;
import com.garofalo.sportyshoes_ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<OrderEntity> getAllOrders(){
        return orderRepository.findAll();
    }

    public OrderEntity getOrder(Long id){
        return orderRepository.findById(id).get();
    }

    public void addOrder(OrderEntity orderEntity){

        orderEntity.setOrderDateCreated(LocalDate.now());
        orderRepository.save(orderEntity);
    }


    public void updateOrder(long id, OrderEntity orderEntity){
        if(orderRepository.findById(id).isPresent()){

            OrderEntity oldOrderEntity = orderRepository.findById(id).get();

            oldOrderEntity.setOrderStatus(orderEntity.getOrderStatus());
            oldOrderEntity.setOrderProducts(orderEntity.getOrderProducts());

            orderRepository.save(oldOrderEntity);
        }
    }

}
