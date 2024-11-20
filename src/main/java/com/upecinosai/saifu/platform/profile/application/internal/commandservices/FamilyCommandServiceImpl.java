package com.upecinosai.saifu.platform.profile.application.internal.commandservices;

import com.upecinosai.saifu.platform.profile.domain.model.aggregates.Family;
import com.upecinosai.saifu.platform.profile.domain.model.commands.CreateFamilyCommand;
import com.upecinosai.saifu.platform.profile.domain.model.entities.User;
import com.upecinosai.saifu.platform.profile.domain.services.FamilyCommandService;
import com.upecinosai.saifu.platform.profile.infrastructure.persistence.jpa.FamilyRepository;
import com.upecinosai.saifu.platform.profile.infrastructure.persistence.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamilyCommandServiceImpl implements FamilyCommandService {

    private final FamilyRepository familyRepository;
    private final UserRepository userRepository;

    public FamilyCommandServiceImpl(FamilyRepository familyRepository, UserRepository userRepository) {
        this.familyRepository = familyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Family> handle(CreateFamilyCommand command) {
        Optional<User> user = userRepository.findById(command.userId());
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found with ID: " + command.userId());
        }

        Family family = new Family(command, user.get());
        return Optional.of(familyRepository.save(family));
    }
}
