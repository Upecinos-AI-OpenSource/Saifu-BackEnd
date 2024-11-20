package com.upecinosai.saifu.platform.profile.infrastructure.persistence.jpa;

import com.upecinosai.saifu.platform.profile.domain.model.aggregates.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
