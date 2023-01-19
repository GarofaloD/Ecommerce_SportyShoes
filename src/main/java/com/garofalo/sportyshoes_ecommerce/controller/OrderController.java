package com.garofalo.sportyshoes_ecommerce.controller;

import com.garofalo.sportyshoes_ecommerce.dto.OrderFormDto;
import com.garofalo.sportyshoes_ecommerce.dto.OrderProductDto;
import com.garofalo.sportyshoes_ecommerce.entity.OrderEntity;
import com.garofalo.sportyshoes_ecommerce.entity.OrderProduct;
import com.garofalo.sportyshoes_ecommerce.entity.ProductEntity;
import com.garofalo.sportyshoes_ecommerce.service.OrderProductService;
import com.garofalo.sportyshoes_ecommerce.service.OrderService;
import com.garofalo.sportyshoes_ecommerce.service.ProductService;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/api")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderProductService orderProductService;

    @RequestMapping("/allorders")
    public List<OrderEntity> getAllOrders(){
        return orderService.getAllOrders();
    }

    @RequestMapping("/order/{id}")
    public OrderEntity getOrderById(@PathVariable long id){
        return orderService.getOrder(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/order")
    public void addOrder(@RequestBody OrderFormDto orderForm) {

        List<OrderProductDto> formDtos = orderForm.getProductOrders();

        //Adding order itself
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderStatus("Placed");
        orderService.addOrder(orderEntity);



        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDto dto : formDtos) {
            //list of products and quantities per order
            OrderProduct orderProduct = new OrderProduct(orderEntity, productService.getProduct(dto.getProductEntity().getProductId()),dto.getQuantity());
            //and adding them to the middle table
            orderProducts.add(orderProductService.createOrder(orderProduct));
        }

        //saving and updating
        orderEntity.setOrderProducts(orderProducts);
        orderService.updateOrder(orderEntity.getOrderId(), orderEntity);

    }




    @RequestMapping(method = RequestMethod.PUT, value="/order/{id}")
    public void updateOrder(@PathVariable long id, OrderEntity orderEntity){
        orderService.updateOrder(id, orderEntity);
    }







}
