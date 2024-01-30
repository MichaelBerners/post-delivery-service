package ru.berners.postal_delivery_service.domain.entity;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class PostageMovements {
    private Long id;
    private Postage postage;
    private PostOffice postOffice;
    private String historyStatus;
    private Date date;
    private Time time;


}
