package com.cashrich.identity.entry;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class StatusEntry {

    private String code;
    private Boolean success;
    private String status;
    private LocalDateTime timeStamp;
    private String message;

}
