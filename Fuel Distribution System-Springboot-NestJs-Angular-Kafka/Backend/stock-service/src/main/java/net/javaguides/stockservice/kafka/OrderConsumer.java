package net.javaguides.stockservice.kafka;

import net.javaguides.basedomains.dto.Order;
import net.javaguides.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;


@Service

public class OrderConsumer {

    static String orderId;
    static String fuelType;
    static int qty;
    private static int qty1=100000;
    private static int qty2=100000;
    private static int qty3=100000;
    private static int qty4=100000;

    static LocalDateTime dateTime=LocalDateTime.now();
    static LocalDate date=LocalDate.now();

    private StockProducer stockProducer;
    private ScheduleProducer scheduleProducer;



    static String status="pending";




    public OrderConsumer(StockProducer stockProducer,ScheduleProducer scheduleProducer){

        this.stockProducer=stockProducer;
        this.scheduleProducer=scheduleProducer;

    }


    public void reserve1 (int amount) {
        this.qty1 = this.qty1-amount;
        this.status="reserved";

    }
    public void reserve2 (int amount) {
       this.qty2 = this.qty2-amount;
        this.status="reserved";

    }
    public void reserve3 (int amount) {
        this.qty3 = this.qty3-amount;
        this.status="reserved";

    }
    public void reserve4 (int amount) {
        this.qty4 = this.qty4-amount;
        this.status="reserved";

    }

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);


    public static String getOrderId() {
        return orderId;
    }

    public static String getFuelType() {
        return fuelType;
    }

    public static int getQty() {
        return qty;
    }

    public static LocalDateTime getDateTime() {
        return dateTime;
    }

    public static LocalDate getDate() {
        return date;
    }

    public StockProducer getStockProducer() {
        return stockProducer;
    }

    public static String getStatus() {
        return status;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}" ,
            groupId = "${spring.kafka.consumer.group-id}")

    public void consume(OrderEvent event){

        LOGGER.info(String.format("Order event received in stock service => %s",event.toString()));

        Order order1=new Order();
        order1=event.order;

        String OId=order1.getOrderId();
        this.orderId=OId;

        String OType=order1.getFuelType();
        this.fuelType=OType;

        int OQty=order1.getQty();
        this.qty=OQty;

        String SOQty=String.valueOf(OQty);


        LOGGER.info(OId);
        LOGGER.info(OType);
        LOGGER.info(SOQty);


        switch (OType) {
            case "Petrol-95":
                LOGGER.info(String.valueOf(" Petrol 95 Current stock before allocation :"+ this.qty1));
                if (OQty < this.qty1) {
                    reserve1(OQty);

                    LOGGER.info(String.valueOf(String.valueOf(OQty))+" Reserved from Petrol 95");
                    order1.setStatus("reserved");
                    stockProducer.sendMessage(event);
                    order1.setDateTime(dateTime);
                    order1.setDate(date);
                    scheduleProducer.sendMessage(event);



                } else {

                    LOGGER.info("Reservation Failed");
                    order1.setStatus("not reserved");
                    stockProducer.sendMessage(event);




                }
                LOGGER.info(String.valueOf(" Petrol 95 Current stock after allocation :"+ qty1));
                break;
            case "Petrol-92":
                LOGGER.info(String.valueOf("Petrol 92 Current stock before allocation :"+ qty2));
                if (OQty < qty2) {
                    reserve2(OQty);

                    LOGGER.info(String.valueOf(String.valueOf(OQty))+" Reserved from Petrol 92");
                    order1.setStatus("reserved");
                    stockProducer.sendMessage(event);
                    order1.setDateTime(dateTime);
                    order1.setDate(date);
                    scheduleProducer.sendMessage(event);

                } else {

                    LOGGER.info("Reservation Failed");
                    order1.setStatus(" not reserved");
                    stockProducer.sendMessage(event);




                }
                LOGGER.info(String.valueOf("Petrol 92 Current stock After Allocation :"+ qty2));
                break;
            case "Diesel-Super":
                LOGGER.info(String.valueOf("Diesel Super Current stock before allocation :"+qty3));
                if (OQty < qty3) {
                    reserve3(OQty);

                    LOGGER.info(String.valueOf(String.valueOf(OQty))+" Reserved from Diesel Super");
                    order1.setStatus("reserved");
                    stockProducer.sendMessage(event);
                    order1.setDateTime(dateTime);
                    order1.setDate(date);
                    scheduleProducer.sendMessage(event);

                } else {

                    LOGGER.info("Reservation Failed");
                    order1.setStatus("not reserved");
                    stockProducer.sendMessage(event);





                }
                LOGGER.info(String.valueOf("Diesel Super Current stock after allocation :"+qty3));
                break;

            case "Diesel-Auto":
                LOGGER.info(String.valueOf("Diesel Auto Current stock before allocation :"+qty4));
                if (OQty < qty4) {
                    reserve4(OQty);

                    LOGGER.info(String.valueOf(String.valueOf(OQty))+" Reserved from Diesel Auto");
                    order1.setStatus("reserved");
                    stockProducer.sendMessage(event);
                    order1.setDateTime(dateTime);
                    order1.setDate(date);
                    scheduleProducer.sendMessage(event);

                } else {

                    LOGGER.info("Reservation Failed");
                    order1.setStatus("not reserved");
                    stockProducer.sendMessage(event);




                }
                LOGGER.info(String.valueOf("Diesel Auto Current stock after allocation :"+qty4));
                break;

        }






    }


}
