package com.upecinosai.saifu.platform.profile.domain.services;

import com.upecinosai.saifu.platform.profile.domain.model.aggregates.Plan;
import com.upecinosai.saifu.platform.profile.domain.model.commands.CreatePlanCommand;

import java.util.Optional;

public interface PlanCommandService {
    Optional<Plan> handle(CreatePlanCommand command);
}
