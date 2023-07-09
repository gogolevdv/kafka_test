package ru.gogol.receivehb.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.gogol.receivehb.kafka.Producer;

@Slf4j
@AllArgsConstructor
@Component
@EnableScheduling
public class ManagerStatusHB {
    @Scheduled(fixedDelayString = "4000")
    public void HBstatusOffSend() {
            Producer.sendMessage("OFFLINE");

    }
    @Scheduled(fixedDelayString = "6000")
    public void HBstatusOnSend() {
            Producer.sendMessage("ONLINE");

    }
}
