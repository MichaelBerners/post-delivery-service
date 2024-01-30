package ru.berners.postal_delivery_service.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.berners.postal_delivery_service.domain.entity.PostageMovements;

import java.util.List;
import java.util.Optional;

public interface PostageMovementsRepository extends JpaRepository<PostageMovements, Long> {
    List<PostageMovements> findAllByPostage(Long id);
}
