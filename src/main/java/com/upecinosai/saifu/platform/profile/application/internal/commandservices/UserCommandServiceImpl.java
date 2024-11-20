package com.upecinosai.saifu.platform.profile.application.internal.commandservices;

import com.upecinosai.saifu.platform.profile.domain.model.commands.CreateUserCommand;
import com.upecinosai.saifu.platform.profile.domain.model.entities.User;
import com.upecinosai.saifu.platform.profile.domain.services.UserCommandService;
import com.upecinosai.saifu.platform.profile.infrastructure.persistence.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(CreateUserCommand command) {
        var user = new User(command);
        var createUser = userRepository.save(user);
        return Optional.of(createUser);
    }
}
