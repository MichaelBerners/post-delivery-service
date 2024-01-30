package ru.berners.postal_delivery_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postal_delivery_service.domain.entity.PostOffice;
import ru.berners.postal_delivery_service.domain.entity.Postage;
import ru.berners.postal_delivery_service.domain.entity.PostageMovements;
import ru.berners.postal_delivery_service.domain.entity.PostageStatus;
import ru.berners.postal_delivery_service.domain.repository.PostageMovementsRepository;
import ru.berners.postal_delivery_service.domain.request.PostageMovementsCreateMoveRequest;
import ru.berners.postal_delivery_service.domain.request.PostageMovementsCreateRequest;
import ru.berners.postal_delivery_service.service.PostOfficeService;
import ru.berners.postal_delivery_service.service.PostageMovementsService;
import ru.berners.postal_delivery_service.service.PostageService;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
@AllArgsConstructor
public class PostageMovementsServiceImpl implements PostageMovementsService {
    private final PostageMovementsRepository postageMovementsRepository;
    private final PostageService postageService;
    private final PostOfficeService postOfficeService;

    @Override
    public void create(PostageMovementsCreateRequest postageMovementsCreateRequest) {    //PostageMovementsCreateRequest postageMovementsCreateRequest
        final PostageMovements savePostageMovements = new PostageMovements();
        final Date date = new Date(System.currentTimeMillis());
        final Time time = new Time(System.currentTimeMillis());
        savePostageMovements.setPostage(postageMovementsCreateRequest.getPostage());
        savePostageMovements.setPostOffice(postageMovementsCreateRequest.getPostOffice());
        savePostageMovements.setHistoryStatus(postageMovementsCreateRequest.getHistoryStatus());
        savePostageMovements.setDate(date);
        savePostageMovements.setTime(time);

        postageMovementsRepository.save(savePostageMovements);
    }

    @Override
    public void addNewPostageMovements(PostageMovementsCreateMoveRequest postageMovementsCreateMoveRequest) {
        final PostOffice readPostOffice = postOfficeService.read(postageMovementsCreateMoveRequest.getPostOfficeId());
        final PostageStatus postageStatus = postageMovementsCreateMoveRequest.getPostageStatus();
        final Postage postageUpdateStatus = postageService.updatePostageStatus(postageMovementsCreateMoveRequest.getPostageId(), postageStatus);
        final PostageMovementsCreateRequest postageMovementsCreateRequest = new PostageMovementsCreateRequest();
        postageMovementsCreateRequest.setPostage(postageUpdateStatus);
        postageMovementsCreateRequest.setPostOffice(readPostOffice);
        postageMovementsCreateRequest.setHistoryStatus(postageStatus.name());
        create(postageMovementsCreateRequest);

    }

    @Override
    public List<PostageMovements> readHistoryMovements(Long postagId) {
        List<PostageMovements> result = postageMovementsRepository.findAllByPostage(postagId);
        if(result.isEmpty()) {
            throw new RuntimeException();
        }
        return result;
    }


}
