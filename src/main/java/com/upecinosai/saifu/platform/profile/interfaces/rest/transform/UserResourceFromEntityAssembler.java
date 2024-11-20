package com.upecinosai.saifu.platform.profile.interfaces.rest.transform;

import com.upecinosai.saifu.platform.profile.domain.model.entities.User;
import com.upecinosai.saifu.platform.profile.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(entity.getUSERID(), entity.getUSERNAME(), entity.getPASSWORD(), entity.getEMAIL(), entity.getUSER_TYPE(), entity.getSTATE());
    }
}
