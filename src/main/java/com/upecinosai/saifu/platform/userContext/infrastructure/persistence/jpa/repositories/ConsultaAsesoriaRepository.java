package com.upecinosai.saifu.platform.userContext.infrastructure.persistence.jpa.repositories;

import com.upecinosai.saifu.platform.userContext.domain.model.entities.ConsultaAsesoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ConsultaAsesoriaRepository extends JpaRepository<ConsultaAsesoria, Long> {
}
