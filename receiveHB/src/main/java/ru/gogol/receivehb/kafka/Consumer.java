package ru.gogol.receivehb.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.gogol.receivehb.kafka.utils.AppConstants;

@Slf4j
@AllArgsConstructor
@Service
public class Consumer {

    @KafkaListener(topics = AppConstants.TOPIC_HB, groupId = AppConstants.GROUP_ID)
    public void listenGroupFoo(String message) {
        log.info("Received Message_HB in group foo: " + message);
    }
}
