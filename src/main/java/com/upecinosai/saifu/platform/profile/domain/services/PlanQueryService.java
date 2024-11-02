package com.upecinosai.saifu.platform.profile.domain.services;

import com.upecinosai.saifu.platform.profile.domain.model.aggregates.Plan;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetAllPlansQuery;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetPlanByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface PlanQueryService {
    List<Plan> handle(GetAllPlansQuery query);
    Optional<Plan> handle(GetPlanByUserIdQuery query);
}
