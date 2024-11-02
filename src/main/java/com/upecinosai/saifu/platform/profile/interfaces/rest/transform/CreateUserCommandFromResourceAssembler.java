package com.upecinosai.saifu.platform.profile.interfaces.rest.transform;

import com.upecinosai.saifu.platform.profile.domain.model.commands.CreateUserCommand;
import com.upecinosai.saifu.platform.profile.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(resource.username(), resource.password(), resource.email(), resource.user_type(), resource.state());
    }
}
