package net.javaguides.scheduleservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name2}")
    private String topicName2;

    //spring bean for kafka topic
    @Bean
    public NewTopic topic(){

        return TopicBuilder.name(topicName2)
                .build();
    }

}
