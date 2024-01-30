package ru.berners.postal_delivery_service.domain.request;

import lombok.Data;
import ru.berners.postal_delivery_service.domain.entity.PostOffice;
import ru.berners.postal_delivery_service.domain.entity.PostageMovementsType;
import ru.berners.postal_delivery_service.domain.entity.Postage;

@Data
public class PostageMovementsCreateRequest {

    private Postage postage;
    private PostOffice postOffice;
    private String historyStatus;
}
