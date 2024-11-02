package com.upecinosai.saifu.platform.finantialData.infrastructure.persistence.jpa;

import com.upecinosai.saifu.platform.finantialData.domain.model.FinantialData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinantialDataRepository extends JpaRepository<FinantialData, Long> {
}
