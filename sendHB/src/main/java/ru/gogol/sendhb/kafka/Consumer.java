package ru.gogol.sendhb.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.gogol.sendhb.kafka.utils.AppConstants;

@Slf4j
@AllArgsConstructor
@Service
public class Consumer {

    public interface ChangeStatus{
        void OnReceivedChangeStatus(String message);
    }

    private final ChangeStatus changeStatus;

    @KafkaListener(topics = AppConstants.TOPIC_HB_STATUS, groupId = AppConstants.GROUP_ID)
    public void listenStatusTopic(String message) {
        log.info("Received HBstatus in group Groupe2: " + message);
        changeStatus.OnReceivedChangeStatus(message);
    }
}
