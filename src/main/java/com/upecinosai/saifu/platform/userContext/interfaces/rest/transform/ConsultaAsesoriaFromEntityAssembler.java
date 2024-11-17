package com.upecinosai.saifu.platform.userContext.interfaces.rest.transform;

import com.upecinosai.saifu.platform.userContext.domain.model.entities.ConsultaAsesoria;
import com.upecinosai.saifu.platform.userContext.interfaces.rest.resources.ConsultaAsesoriaResource;
import org.springframework.stereotype.Component;

@Component
public class ConsultaAsesoriaFromEntityAssembler {
    public static ConsultaAsesoriaResource toResourceFromEntity(ConsultaAsesoria entity) {
        return new ConsultaAsesoriaResource(
                entity.getId(),
                entity.getTipoConsulta(),
                entity.getFechaConsulta(),
                entity.getResultado()
        );
    }
}
