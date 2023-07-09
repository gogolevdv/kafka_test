package ru.gogol.receivehb.kafka.utils;

public enum StatusHB {
    ON("ONLINE"),
    OFF("OFFLINE"),
    DIS("DISABLED");

    public final String status;

    StatusHB (String status){
        this.status=status;
    }

    public String getStatus(StatusHB statusHB){
        return statusHB.toString();
    }
}