package com.upecinosai.saifu.platform.finantialEducation.infrastructure.persistence.jpa;

import com.upecinosai.saifu.platform.finantialEducation.domain.model.FinantialEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinantialEducationRepository extends JpaRepository<FinantialEducation, Long> {
}
