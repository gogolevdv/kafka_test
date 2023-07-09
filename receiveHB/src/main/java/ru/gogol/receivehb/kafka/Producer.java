package ru.gogol.receivehb.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.gogol.receivehb.kafka.utils.AppConstants;


@Slf4j
@AllArgsConstructor
@Service
public class Producer {

    private static final KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(KafkaProducerConfig.producerFactory());


    public static void sendMessage(String msg) {
        kafkaTemplate.send(AppConstants.TOPIC_HB_STATUS,  msg);

    }

}
