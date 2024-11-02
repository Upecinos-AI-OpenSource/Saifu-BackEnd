package com.upecinosai.saifu.platform.profile.application.internal.queryservices;

import com.upecinosai.saifu.platform.profile.domain.model.aggregates.Plan;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetAllPlansQuery;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetPlanByUserIdQuery;
import com.upecinosai.saifu.platform.profile.domain.services.PlanQueryService;
import com.upecinosai.saifu.platform.profile.infrastructure.persistence.jpa.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanQueryServiceImpl implements PlanQueryService {

    private final PlanRepository planRepository;

    public PlanQueryServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public List<Plan> handle(GetAllPlansQuery query) {
        return planRepository.findAll();
    }

    @Override
    public Optional<Plan> handle(GetPlanByUserIdQuery query) {
        return planRepository.findById(query.userId());
    }
}