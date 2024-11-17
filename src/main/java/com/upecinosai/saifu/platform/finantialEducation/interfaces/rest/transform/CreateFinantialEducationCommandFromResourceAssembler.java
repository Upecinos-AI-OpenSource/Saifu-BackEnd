package com.upecinosai.saifu.platform.finantialEducation.interfaces.rest.transform;

import com.upecinosai.saifu.platform.finantialEducation.domain.model.aggregates.FinantialEducation;
import com.upecinosai.saifu.platform.finantialEducation.domain.model.entities.Preguntas;
import com.upecinosai.saifu.platform.finantialEducation.domain.model.entities.Respuestas;
import com.upecinosai.saifu.platform.finantialEducation.interfaces.rest.resources.FinantialEducationResource;
import org.springframework.stereotype.Component;

@Component
public class CreateFinantialEducationCommandFromResourceAssembler {

    public FinantialEducation toEntity(FinantialEducationResource resource, Preguntas pregunta, Respuestas respuesta) {
        FinantialEducation finantialEducation = new FinantialEducation();
        finantialEducation.setTitulo(resource.getTitulo());
        finantialEducation.setPregunta(pregunta);
        finantialEducation.setRespuesta(respuesta);
        return finantialEducation;
    }
}
