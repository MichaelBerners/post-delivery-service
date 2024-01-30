package ru.berners.postal_delivery_service.service;

import ru.berners.postal_delivery_service.domain.entity.Postage;
import ru.berners.postal_delivery_service.domain.entity.PostageStatus;
import ru.berners.postal_delivery_service.domain.request.PostCreateRequest;

public interface PostageService {

    void create(PostCreateRequest postCreateRequest);
    Postage updatePostageStatus(Long id, PostageStatus postageStatus);
    Postage read(Long id);
    PostageStatus readStatus(Long id);
}
