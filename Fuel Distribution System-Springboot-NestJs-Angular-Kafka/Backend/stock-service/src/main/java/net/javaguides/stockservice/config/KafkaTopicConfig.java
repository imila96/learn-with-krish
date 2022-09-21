package net.javaguides.stockservice.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name1}")
    private String topicName1;

    //spring bean for kafka topic
    @Bean
    public NewTopic topic(){

        return TopicBuilder.name(topicName1)
                .build();
    }

}
