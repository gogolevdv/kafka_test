package ru.gogol.sendhb.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("spring.kafka.producer.bootstrap-servers")
    String bootstrapservers;

    @Value("spring.kafka.producer.key-serializer")
    String key;

    @Value("spring.kafka.producer.value-serializer")
    String value;

//    public static ProducerFactory<String, String> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(
//                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "localhost:9092");
//        configProps.put(
//                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                StringSerializer.class);
//        configProps.put(
//                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                StringSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }

    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(
            new DefaultKafkaProducerFactory<>(Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                    bootstrapservers, ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                    key, ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                    value)));
    }

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("HBtopic").build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("HBstatusTopic").build();
    }
}
