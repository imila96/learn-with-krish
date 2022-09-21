package net.javaguides.orderservice.kafka;


import net.javaguides.basedomains.dto.Order;
import net.javaguides.basedomains.dto.OrderEvent;
import net.javaguides.basedomains.dto.Schedule;
import net.javaguides.basedomains.dto.ScheduleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduleConsumer {


    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleConsumer.class);



    @KafkaListener(
            topics = "scheduler_topic" ,
            groupId = "${spring.kafka.consumer.group-id}")

    public void consume(String x) {

        LOGGER.info(String.format("schedule event received in order service => %s", ""));
        LOGGER.info(x);

        String[] arr = x.split(" ");
        String date=arr[5].substring(5,15);
        LOGGER.info(date+" : scheduled date");
        Schedule s=new Schedule();
        s.setDate(date);
        s.setStatus("reserved");

        ScheduleEvent se=new ScheduleEvent();

       se.setSchedule(s);
       this.senew=se;
       this.de=date;




    }

    public static ScheduleEvent senew;
    public static String de;
}

