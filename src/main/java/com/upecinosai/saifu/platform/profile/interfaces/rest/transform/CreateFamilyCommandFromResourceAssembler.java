package com.upecinosai.saifu.platform.profile.interfaces.rest.transform;

import com.upecinosai.saifu.platform.profile.domain.model.commands.CreateFamilyCommand;
import com.upecinosai.saifu.platform.profile.interfaces.rest.resources.CreateFamilyResource;

public class CreateFamilyCommandFromResourceAssembler {
    public static CreateFamilyCommand toCommandFromResource(CreateFamilyResource resource) {
        return new CreateFamilyCommand(
                resource.userId(),
                resource.familyName(),
                resource.members(),
                resource.direction(),
                resource.phoneNumber()
        );
    }
}
