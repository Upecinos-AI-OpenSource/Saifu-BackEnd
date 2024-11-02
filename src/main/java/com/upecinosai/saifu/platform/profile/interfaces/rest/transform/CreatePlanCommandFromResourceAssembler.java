package com.upecinosai.saifu.platform.profile.interfaces.rest.transform;

import com.upecinosai.saifu.platform.profile.domain.model.commands.CreatePlanCommand;
import com.upecinosai.saifu.platform.profile.interfaces.rest.resources.CreatePlanResource;

public class CreatePlanCommandFromResourceAssembler {
    public static CreatePlanCommand toCommandFromResource(CreatePlanResource resource) {
        return new CreatePlanCommand(
                resource.userId(),
                resource.planName(),
                resource.description(),
                resource.cost(),
                resource.monthDuration()
        );
    }
}
