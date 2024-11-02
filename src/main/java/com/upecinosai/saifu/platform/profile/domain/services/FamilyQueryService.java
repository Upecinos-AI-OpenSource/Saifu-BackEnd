package com.upecinosai.saifu.platform.profile.domain.services;

import com.upecinosai.saifu.platform.profile.domain.model.aggregates.Family;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetAllFamiliesQuery;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetFamilyByIdQuery;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetFamilyByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface FamilyQueryService {
    List<Family> handle(GetAllFamiliesQuery query);
    Optional<Family> handle(GetFamilyByIdQuery query);
    List<Family> handle(GetFamilyByUserIdQuery query);
}
