package net.javaguides.scheduleservice.controller;

import net.javaguides.basedomains.dto.Order;
import net.javaguides.basedomains.dto.OrderEvent;
import net.javaguides.basedomains.dto.Schedule;
import net.javaguides.basedomains.dto.ScheduleEvent;
import net.javaguides.scheduleservice.kafka.StockConsumer;
import net.javaguides.scheduleservice.kafka.ScheduleProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v3")
public class ScheduleController {



    private ScheduleProducer scheduleProducer;

    public ScheduleController(ScheduleProducer scheduleProducer) {
        this.scheduleProducer = scheduleProducer;
    }

    @PostMapping("/schedules")
    public String placeSchedule(@RequestBody Order order){

      //  order.setOrderId(StockConsumer.getOrderId());
     //   order.setFuelType(StockConsumer.getFuelType().toString());
       // order.setStatus(StockConsumer.getStatus());
       // order.setQty(StockConsumer.getQty());
      //  order.setDateTime(StockConsumer.getDateTime());
      //  order.setDate(StockConsumer.getDate());

      //  OrderEvent orderEvent=new OrderEvent();

       // orderEvent.setOrder(order);

       // scheduleProducer.sendMessage(orderEvent);

        return "Order placed sucessfully ";


    }
}
