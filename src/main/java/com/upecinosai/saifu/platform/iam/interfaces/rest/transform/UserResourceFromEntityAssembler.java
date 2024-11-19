package com.upecinosai.saifu.platform.iam.interfaces.rest.transform;

import com.upecinosai.saifu.platform.iam.domain.model.aggregates.User;
import com.upecinosai.saifu.platform.iam.interfaces.rest.resources.UserResource;
import com.upecinosai.saifu.platform.iam.domain.model.entities.Role;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity){
        var roles = entity.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(entity.getId(), entity.getUsername(), roles);
    }
}
