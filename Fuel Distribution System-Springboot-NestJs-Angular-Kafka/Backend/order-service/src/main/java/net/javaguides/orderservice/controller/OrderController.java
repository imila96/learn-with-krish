package net.javaguides.orderservice.controller;


import net.javaguides.basedomains.dto.*;
import net.javaguides.orderservice.kafka.OrderProducer;
import net.javaguides.orderservice.kafka.ScheduleConsumer;
import net.javaguides.orderservice.kafka.StockConsumer;
import net.javaguides.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@EnableMongoRepositories("net.javaguides.orderservice.repository")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/v1")
public class OrderController {


private OrderProducer orderProducer;

    @Autowired
    public OrderRepository orderRepository;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public OrderEvent placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent=new OrderEvent();

        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        try {
            Thread.sleep(5100);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        return StockConsumer.os;


    }
    @GetMapping("/findAllOrders")
    public List<Products> getStock(){


        return orderRepository.findAll();
    }

    @GetMapping("/findorder/{orderId}")
    public List<Products> findOrder (@PathVariable("orderId") String orderId){


        return orderRepository.findOrderByorderId(orderId);
    }
public Order createOrder(@RequestBody Order order){
        return null;
}


}
