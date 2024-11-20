package com.upecinosai.saifu.platform.profile.interfaces.rest.resources;

import com.upecinosai.saifu.platform.profile.domain.model.valueObjects.State;

public record UserResource(Long user_id, String username, String password, String email, String user_type, State state) {
}
