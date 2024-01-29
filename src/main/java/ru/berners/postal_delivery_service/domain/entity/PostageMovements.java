package ru.berners.postal_delivery_service.domain.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class PostageMovements {
    private Long id;
    private Postage postage;
    private PostOffice postOffice;
    private PostageStatus postageStatus;
    private Date date;
    private Time time;


}
