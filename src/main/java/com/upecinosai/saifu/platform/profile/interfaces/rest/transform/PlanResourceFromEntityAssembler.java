package com.upecinosai.saifu.platform.profile.interfaces.rest.transform;

import com.upecinosai.saifu.platform.profile.domain.model.aggregates.Plan;
import com.upecinosai.saifu.platform.profile.interfaces.rest.resources.PlanResource;

public record PlanResourceFromEntityAssembler() {
    public static PlanResource toResourceFromEntity(Plan entity) {
        return new PlanResource(
                entity.getPLANID(),
                entity.getPLAN_NAME(),
                entity.getDESCRIPTION(),
                entity.getCOST(),
                entity.getMONTH_DURATION(),
                entity.getUser().getUSERID()
        );
    }
}
