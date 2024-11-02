package com.upecinosai.saifu.platform.profile.domain.services;

import com.upecinosai.saifu.platform.profile.domain.model.commands.CreateUserCommand;
import com.upecinosai.saifu.platform.profile.domain.model.entities.User;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(CreateUserCommand command);
}
