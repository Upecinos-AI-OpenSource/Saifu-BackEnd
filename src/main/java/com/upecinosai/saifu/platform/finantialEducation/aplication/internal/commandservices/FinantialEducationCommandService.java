package com.upecinosai.saifu.platform.finantialEducation.aplication.internal.commandservices;

import com.upecinosai.saifu.platform.finantialEducation.domain.model.FinantialEducation;
import com.upecinosai.saifu.platform.finantialEducation.infrastructure.persistence.jpa.FinantialEducationRepository;
import org.springframework.stereotype.Service;

@Service
public class FinantialEducationCommandService {

    private final FinantialEducationRepository repository;

    public FinantialEducationCommandService(FinantialEducationRepository repository) {
        this.repository = repository;
    }

    public FinantialEducation save(FinantialEducation finantialEducation) {
        return repository.save(finantialEducation);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
