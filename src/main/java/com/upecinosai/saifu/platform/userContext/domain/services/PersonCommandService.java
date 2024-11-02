package com.upecinosai.saifu.platform.userContext.domain.services;

import com.upecinosai.saifu.platform.userContext.domain.model.aggregates.Person;
import com.upecinosai.saifu.platform.userContext.domain.model.commands.CreatePersonCommand;

import java.util.Optional;

public interface PersonCommandService {
    Optional<Person> handle(CreatePersonCommand command);
}
