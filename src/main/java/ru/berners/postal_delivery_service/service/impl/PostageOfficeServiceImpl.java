package ru.berners.postal_delivery_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postal_delivery_service.domain.entity.PostOffice;
import ru.berners.postal_delivery_service.domain.repository.PostOfficeRepository;
import ru.berners.postal_delivery_service.service.PostOfficeService;

import java.time.LocalDate;
import java.util.Optional;
@Service
@AllArgsConstructor
public class PostageOfficeServiceImpl implements PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;
    @Override
    public PostOffice read(Long id) {
        PostOffice result = postOfficeRepository.findById(id).orElseThrow(() -> new RuntimeException("Переделать"));
        return result;
    }
}
