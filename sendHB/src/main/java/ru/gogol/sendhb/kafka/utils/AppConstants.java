package ru.gogol.sendhb.kafka.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AppConstants {
    public static final String TOPIC_NAME = "HBtopic";
    public static final String GROUP_ID = "group_id";
    public static final String message = "1234567";
    public static String status = StatusHB.ON.getStatus(StatusHB.ON);


}