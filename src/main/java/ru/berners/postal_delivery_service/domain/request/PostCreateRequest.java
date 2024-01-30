package ru.berners.postal_delivery_service.domain.request;

import lombok.Data;
import ru.berners.postal_delivery_service.domain.entity.PostOffice;
import ru.berners.postal_delivery_service.domain.entity.PostageType;

@Data
public class PostCreateRequest {
    private String recipientName;
    private String recipientIndex;
    private String recipientAddress;
    private PostageType postageType;
    private Long postOfficeId;

}
