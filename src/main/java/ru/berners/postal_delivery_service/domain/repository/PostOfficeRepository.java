package ru.berners.postal_delivery_service.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.berners.postal_delivery_service.domain.entity.PostOffice;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {
}
