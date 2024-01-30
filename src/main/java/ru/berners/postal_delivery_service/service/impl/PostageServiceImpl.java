package ru.berners.postal_delivery_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postal_delivery_service.domain.entity.PostOffice;
import ru.berners.postal_delivery_service.domain.entity.Postage;
import ru.berners.postal_delivery_service.domain.entity.PostageStatus;
import ru.berners.postal_delivery_service.domain.repository.PostageRepository;
import ru.berners.postal_delivery_service.domain.request.PostCreateRequest;
import ru.berners.postal_delivery_service.domain.request.PostageMovementsCreateRequest;
import ru.berners.postal_delivery_service.service.PostOfficeService;
import ru.berners.postal_delivery_service.service.PostageMovementsService;
import ru.berners.postal_delivery_service.service.PostageService;

@Service
@AllArgsConstructor
public class PostageServiceImpl implements PostageService {
    private final PostageRepository postageRepository;
    private final PostOfficeService postOfficeService;
    private final PostageMovementsService postageMovementsService;

    @Override
    public void create(PostCreateRequest postCreateRequest) {
        final PostOffice savePostOffice = postOfficeService.read(postCreateRequest.getPostOfficeId());
        final Postage newPostage = new Postage();
        newPostage.setPostageStatus(PostageStatus.REGISTERED);
        newPostage.setRecipientName(postCreateRequest.getRecipientName());
        newPostage.setRecipientIndex(postCreateRequest.getRecipientIndex());
        newPostage.setRecipientAddress(postCreateRequest.getRecipientAddress());
        newPostage.setPostageType(postCreateRequest.getPostageType());
        final Postage savePostage = postageRepository.save(newPostage);
        final PostageMovementsCreateRequest saveCreate = new PostageMovementsCreateRequest();
        saveCreate.setPostage(savePostage);
        saveCreate.setPostOffice(savePostOffice);
        saveCreate.setHistoryStatus(PostageStatus.REGISTERED.name());
        //saveCreate.setPostageStatus(PostageStatus.REGISTRATION);
        postageMovementsService.create(saveCreate);
    }



    @Override
    public Postage updatePostageStatus(Long id, PostageStatus postageStatus) {
        final Postage postageUpdate = postageRepository.findById(id).orElseThrow(() -> new RuntimeException("переделать"));
        postageUpdate.setPostageStatus(postageStatus);
        final Postage save = postageRepository.save(postageUpdate);
        return save;
    }

    @Override
    public Postage read(Long id) {
        Postage postageResult = postageRepository.findById(id).orElseThrow(() -> new RuntimeException());

        return postageResult;
    }

    @Override
    public PostageStatus readStatus(Long id) {
        Postage read = read(id);
        PostageStatus postageStatus = read.getPostageStatus();

        return postageStatus;

    }
}
