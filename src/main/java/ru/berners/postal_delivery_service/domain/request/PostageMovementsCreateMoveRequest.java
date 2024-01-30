package ru.berners.postal_delivery_service.domain.request;

import lombok.Data;
import ru.berners.postal_delivery_service.domain.entity.PostageStatus;

@Data
public class PostageMovementsCreateMoveRequest {
    private Long postageId;
    private Long postOfficeId;
    private PostageStatus postageStatus;
}
