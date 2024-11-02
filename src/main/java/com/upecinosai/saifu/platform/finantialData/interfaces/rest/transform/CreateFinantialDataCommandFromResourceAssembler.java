package com.upecinosai.saifu.platform.finantialData.interfaces.rest.transform;

import com.upecinosai.saifu.platform.finantialData.domain.model.FinantialData;
import com.upecinosai.saifu.platform.finantialData.interfaces.rest.resources.FinantialDataResource;
import org.springframework.stereotype.Component;

@Component
public class CreateFinantialDataCommandFromResourceAssembler {

    public FinantialData toEntity(FinantialDataResource resource) {
        FinantialData finantialData = new FinantialData();
        finantialData.setIdUsuario(resource.getIdUsuario());
        finantialData.setTipoDato(resource.getTipoDato());
        finantialData.setMonto(resource.getMonto());
        finantialData.setFecha(resource.getFecha());
        finantialData.setDescripcion(resource.getDescripcion());
        return finantialData;
    }
}
