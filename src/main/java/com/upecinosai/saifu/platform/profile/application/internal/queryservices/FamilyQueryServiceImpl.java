package com.upecinosai.saifu.platform.profile.application.internal.queryservices;

import com.upecinosai.saifu.platform.profile.domain.model.aggregates.Family;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetAllFamiliesQuery;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetFamilyByIdQuery;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetFamilyByUserIdQuery;
import com.upecinosai.saifu.platform.profile.domain.services.FamilyQueryService;
import com.upecinosai.saifu.platform.profile.infrastructure.persistence.jpa.FamilyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyQueryServiceImpl implements FamilyQueryService {

    private final FamilyRepository familyRepository;

    public FamilyQueryServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Override
    public List<Family> handle(GetAllFamiliesQuery query) {
        return familyRepository.findAll();
    }

    @Override
    public Optional<Family> handle(GetFamilyByIdQuery query) {
        return familyRepository.findById(query.familyId());
    }

    @Override
    public List<Family> handle(GetFamilyByUserIdQuery query) {
        return familyRepository.findByUser_USERID(query.userId());
    }
}
