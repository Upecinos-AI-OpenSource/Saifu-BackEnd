package com.upecinosai.saifu.platform.userInflation.infraestructure.persistence.jpa;

import com.upecinosai.saifu.platform.userInflation.domain.model.UserInflation;
import com.upecinosai.saifu.platform.userInflation.domain.model.UserInflationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInflationRepository extends JpaRepository<UserInflation, UserInflationId> {
}
