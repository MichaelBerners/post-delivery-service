package ru.berners.postal_delivery_service.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

/**
 * сущность описывающая почтовое отправление
 */
@Data
@Entity
@Table(name = "postage")
public class Postage {

    private Long id;
    private String recipientName;
    private PostageType postageType;
    private String recipientIndex;
    //private PostOffice postOffice;
    private String recipientAddress;
    private PostageStatus postageStatus;
    private List<PostageMovements> postageMovements;



}
