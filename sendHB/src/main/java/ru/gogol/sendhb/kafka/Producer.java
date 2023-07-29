package ru.gogol.sendhb.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.gogol.sendhb.kafka.utils.AppConstants;


@Slf4j
@AllArgsConstructor
@Service
public class Producer {

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String msg) {
        kafkaTemplate.send(AppConstants.TOPIC_HB,  msg);

    }

}
