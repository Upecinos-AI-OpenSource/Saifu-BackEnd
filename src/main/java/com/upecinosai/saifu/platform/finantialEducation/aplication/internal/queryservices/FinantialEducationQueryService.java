package com.upecinosai.saifu.platform.finantialEducation.aplication.internal.queryservices;

import com.upecinosai.saifu.platform.finantialEducation.domain.model.FinantialEducation;
import com.upecinosai.saifu.platform.finantialEducation.infrastructure.persistence.jpa.FinantialEducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinantialEducationQueryService {

    private final FinantialEducationRepository repository;

    public FinantialEducationQueryService(FinantialEducationRepository repository) {
        this.repository = repository;
    }

    public List<FinantialEducation> findAll() {
        return repository.findAll();
    }

    public Optional<FinantialEducation> findById(Long id) {
        return repository.findById(id);
    }
}
