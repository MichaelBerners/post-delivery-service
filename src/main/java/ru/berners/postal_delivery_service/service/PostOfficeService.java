package ru.berners.postal_delivery_service.service;

import ru.berners.postal_delivery_service.domain.entity.PostOffice;

import java.util.Optional;

public interface PostOfficeService {
    PostOffice read(Long id);
}
