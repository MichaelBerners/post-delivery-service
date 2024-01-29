package ru.berners.postal_delivery_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postal_delivery_service.domain.repository.PostageRepository;

@Service
@AllArgsConstructor
public class PostageServiceImpl {
    private final PostageRepository postageRepository;

    public void create() {

    }
}
