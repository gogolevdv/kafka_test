package ru.gogol.sendhb.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.gogol.sendhb.kafka.Producer;
import ru.gogol.sendhb.kafka.utils.AppConstants;
import ru.gogol.sendhb.kafka.utils.StatusHB;

@Slf4j
@AllArgsConstructor
@Component
@EnableScheduling
public class Message {
    Message(){
        statusHB= AppConstants.status;
    }

    @Autowired
    public Producer producer;

     StatusHB statusHB;

    @Scheduled(fixedDelayString = "1000")
    public void HBsend() {
        log.info("Hello:" + statusHB);
        if (!statusHB.status.equals("DISABLED")) {
            producer.sendMessage(statusHB.status);
        } else {
            log.info("Hello: not sent");
        }
    }


//    @Scheduled(fixedDelayString = "3000")
//    public void SetStausHB_OFF() {
//        AppConstants.status = StatusHB.OFF.status;
//    }
//
//    @Scheduled(fixedDelayString = "2000")
//    public void SetStausHB_ON() {
//        AppConstants.status = StatusHB.ON.status;
//    }
//
//    @Scheduled(fixedDelayString = "5000")
//    public void SetStausHB_DIS() {
//        AppConstants.status = StatusHB.DIS.status;
//    }
}

