package com.upecinosai.saifu.platform.finantialEducation.infrastructure.persistence.jpa;

import com.upecinosai.saifu.platform.finantialEducation.domain.model.entities.Preguntas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntasRepository extends JpaRepository<Preguntas, Long> {
}
