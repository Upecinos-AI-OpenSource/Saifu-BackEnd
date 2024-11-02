package com.upecinosai.saifu.platform.userContext.infrastructure.persistence.jpa.repositories;

import com.upecinosai.saifu.platform.userContext.domain.model.aggregates.UserConsult;
import com.upecinosai.saifu.platform.userContext.domain.model.aggregates.UserConsultId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConsultRepository extends JpaRepository<UserConsult, UserConsultId> { }

