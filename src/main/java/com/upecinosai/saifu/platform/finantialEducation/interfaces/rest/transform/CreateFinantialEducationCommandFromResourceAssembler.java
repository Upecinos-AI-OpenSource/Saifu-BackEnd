package com.upecinosai.saifu.platform.finantialEducation.interfaces.rest.transform;

import com.upecinosai.saifu.platform.finantialEducation.domain.model.FinantialEducation;
import com.upecinosai.saifu.platform.finantialEducation.interfaces.rest.resources.FinantialEducationResource;
import org.springframework.stereotype.Component;

@Component
public class CreateFinantialEducationCommandFromResourceAssembler {

    public FinantialEducation toEntity(FinantialEducationResource resource) {
        FinantialEducation finantialEducation = new FinantialEducation();
        finantialEducation.setTitulo(resource.getTitulo());
        finantialEducation.setIdRespuesta(resource.getIdRespuesta());
        finantialEducation.setIdPreguntas(resource.getIdPreguntas());
        return finantialEducation;
    }
}
