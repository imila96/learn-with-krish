package net.javaguides.stockservice.controller;


import net.javaguides.basedomains.dto.Order;
import net.javaguides.basedomains.dto.OrderEvent;
import net.javaguides.basedomains.dto.Stock;
import net.javaguides.basedomains.dto.StockEvent;
import net.javaguides.stockservice.kafka.OrderConsumer;
import net.javaguides.stockservice.kafka.StockProducer;
import net.javaguides.stockservice.kafka.OrderConsumer;
import net.javaguides.stockservice.kafka.StockProducer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/v1")
public class StockController {



    private StockProducer stockProducer;

    public StockController(StockProducer stockProducer) {
        this.stockProducer = stockProducer;
    }

    @PostMapping("/update")
    public String placeOrder1(Order order){

        order.setOrderId(OrderConsumer.getOrderId());
        order.setFuelType(OrderConsumer.getFuelType().toString());
        order.setStatus(OrderConsumer.getStatus());
        order.setQty(OrderConsumer.getQty());
        order.setDateTime(OrderConsumer.getDateTime());
        order.setDate(OrderConsumer.getDate());

        OrderEvent orderEvent=new OrderEvent();

        orderEvent.setOrder(order);

        stockProducer.sendMessage(orderEvent);

        return "Order placed sucessfully ";


    }

}
