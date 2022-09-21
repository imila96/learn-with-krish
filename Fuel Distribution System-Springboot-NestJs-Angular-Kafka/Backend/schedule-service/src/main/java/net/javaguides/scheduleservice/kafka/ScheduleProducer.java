package net.javaguides.scheduleservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.basedomains.dto.OrderEvent;
import net.javaguides.basedomains.dto.ScheduleEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ScheduleProducer {

    private static final String TOPIC="scheduler_topic";
    Logger logger= LoggerFactory.getLogger(ScheduleProducer.class);

    private KafkaTemplate<String,String> kafkaTemplate;

    public ScheduleProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(OrderEvent orderEvent){
        logger.info("publishing to : "+TOPIC+" message :"+orderEvent.toString() );

            kafkaTemplate.send(TOPIC,orderEvent.toString());


    }

}
