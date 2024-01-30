package ru.berners.postal_delivery_service.service;

import ru.berners.postal_delivery_service.domain.entity.PostageMovements;
import ru.berners.postal_delivery_service.domain.request.PostageMovementsCreateMoveRequest;
import ru.berners.postal_delivery_service.domain.request.PostageMovementsCreateRequest;

import java.util.List;

public interface PostageMovementsService {
    void create(PostageMovementsCreateRequest postageMovementsCreateRequest);
    void addNewPostageMovements(PostageMovementsCreateMoveRequest postageMovementsCreateMoveRequest);
    List<PostageMovements> readHistoryMovements(Long postagId);

}
