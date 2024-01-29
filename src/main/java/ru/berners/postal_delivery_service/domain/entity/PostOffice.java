package ru.berners.postal_delivery_service.domain.entity;

import java.util.List;

public class PostOffice {
    private Long id;
    private String index; //возможно использование индекса вместо id
    private String name;
    private String address;
    private List<Postage> postageList;

}
