package com.upecinosai.saifu.platform.iam.application.internal.commandservices;

import com.upecinosai.saifu.platform.iam.application.internal.outboundservices.hashingService.HashingService;
import com.upecinosai.saifu.platform.iam.domain.model.aggregates.User;
import com.upecinosai.saifu.platform.iam.domain.services.UserCommandService;
import com.upecinosai.saifu.platform.iam.domain.model.commands.SignInCommand;
import com.upecinosai.saifu.platform.iam.domain.model.commands.SignUpCommand;
import com.upecinosai.saifu.platform.iam.application.internal.outboundservices.tokens.TokenService;
import com.upecinosai.saifu.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.upecinosai.saifu.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;

    public UserCommandServiceImpl(UserRepository userRepository, RoleRepository roleRepository, HashingService hashingService, TokenService tokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByUsername(command.username())) {
            throw new RuntimeException("Username already exists");
        }
        var roles = command.roles().stream().map(
                role -> roleRepository.findByName(role.getName()).orElseThrow(
                        () -> new RuntimeException("Role name not found"))).toList();

        var user = new User(command.username(), hashingService.encode(command.password()), roles);

        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty()) throw new RuntimeException("Username not found");
        if (!hashingService.matches(command.password(), user.get().getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        var token = tokenService.generateToken(user.get().getUsername());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }
}