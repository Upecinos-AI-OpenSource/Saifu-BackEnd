package com.upecinosai.saifu.platform.profile.domain.services;

import com.upecinosai.saifu.platform.profile.domain.model.aggregates.Family;
import com.upecinosai.saifu.platform.profile.domain.model.commands.CreateFamilyCommand;

import java.util.Optional;

public interface FamilyCommandService {
    Optional<Family> handle(CreateFamilyCommand command);
}
