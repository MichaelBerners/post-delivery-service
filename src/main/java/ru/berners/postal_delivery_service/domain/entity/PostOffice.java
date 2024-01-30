package ru.berners.postal_delivery_service.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "post_office")
public class PostOffice {

    @Id
    private Long id;

    private String index; //возможно использование индекса вместо id
    private String name;
    private String address;
    //private List<PostageMovements> postageMovements;

}
