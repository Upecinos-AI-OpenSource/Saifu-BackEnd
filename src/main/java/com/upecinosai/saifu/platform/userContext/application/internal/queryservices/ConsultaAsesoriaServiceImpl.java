package com.upecinosai.saifu.platform.userContext.application.internal.queryservices;

import com.upecinosai.saifu.platform.userContext.domain.model.entities.ConsultaAsesoria;
import com.upecinosai.saifu.platform.userContext.domain.model.queries.GetAllConsultasAsesoriasQuery;
import com.upecinosai.saifu.platform.userContext.domain.model.queries.GetConsultaAsesoriaByIdQuery;
import com.upecinosai.saifu.platform.userContext.domain.services.ConsultaAsesoriaQueryService;
import com.upecinosai.saifu.platform.userContext.infrastructure.persistence.jpa.repositories.ConsultaAsesoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaAsesoriaServiceImpl implements ConsultaAsesoriaQueryService {

    private final ConsultaAsesoriaRepository repository;

    public ConsultaAsesoriaServiceImpl(ConsultaAsesoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ConsultaAsesoria> handle(GetAllConsultasAsesoriasQuery query) {
        return repository.findAll();
    }

    @Override
    public Optional<ConsultaAsesoria> handle(GetConsultaAsesoriaByIdQuery query) {
        return repository.findById(query.idConsulta());
    }

}
