package com.upecinosai.saifu.platform.finantialEducation.interfaces.rest.transform;

import com.upecinosai.saifu.platform.finantialEducation.domain.model.FinantialEducation;
import com.upecinosai.saifu.platform.finantialEducation.interfaces.rest.resources.FinantialEducationResource;
import org.springframework.stereotype.Component;

@Component
public class FinantialEducationResourceFromEntityAssembler {

    public FinantialEducationResource toResource(FinantialEducation entity) {
        FinantialEducationResource resource = new FinantialEducationResource();
        resource.setId(entity.getId());
        resource.setTitulo(entity.getTitulo());
        resource.setIdRespuesta(entity.getIdRespuesta());
        resource.setIdPreguntas(entity.getIdPreguntas());
        return resource;
    }
}
