package ru.gogol.sendhb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gogol.sendhb.kafka.Consumer;
import ru.gogol.sendhb.kafka.utils.StatusHB;

@Component
public class ChangeStatus implements Consumer.ChangeStatus {

    @Autowired
    Message messageMy;

    @Override
    public void OnReceivedChangeStatus(String message) {

        if (message.equals("ONLINE")) {
            messageMy.statusHB = StatusHB.ON;
        } else if (message.equals("OFFLINE")) {
            messageMy.statusHB = StatusHB.OFF;
        } else if (message.equals("DISABLED")) {
            messageMy.statusHB = StatusHB.DIS;
        }

    }
}
