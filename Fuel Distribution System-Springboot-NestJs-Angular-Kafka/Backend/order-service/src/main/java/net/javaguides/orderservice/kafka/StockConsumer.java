package net.javaguides.orderservice.kafka;

import net.javaguides.basedomains.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service

public class StockConsumer {


    private static final Logger LOGGER = LoggerFactory.getLogger(StockConsumer.class);



    @KafkaListener(
            topics = "${spring.kafka.topic.name1}" ,
            groupId = "${spring.kafka.consumer.group-id}")

    public void consume(OrderEvent event){

        LOGGER.info(String.format("Stock event received in order service => %s",event.toString()));

        Order order2=new Order();
        order2=event.order;




        String SId=order2.getOrderId();
        String SType=order2.getFuelType();
        String SStatus=order2.getStatus();
        int SQty=order2.getQty();

        String SOQty=String.valueOf(SQty);


        LOGGER.info(SId);
        LOGGER.info(SType);
        LOGGER.info(SOQty);
        LOGGER.info(SStatus);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
event.date=ScheduleConsumer.de;

this.os=event;






    }
    public static OrderEvent os;

}
