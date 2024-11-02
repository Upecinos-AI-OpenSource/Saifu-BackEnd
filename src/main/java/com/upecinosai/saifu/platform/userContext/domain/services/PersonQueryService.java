package com.upecinosai.saifu.platform.userContext.domain.services;

import com.upecinosai.saifu.platform.userContext.domain.model.aggregates.Person;
import com.upecinosai.saifu.platform.userContext.domain.model.queries.GetAllPersonsQuery;
import com.upecinosai.saifu.platform.userContext.domain.model.queries.GetPersonByEmailQuery;
import com.upecinosai.saifu.platform.userContext.domain.model.queries.GetPersonByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PersonQueryService {
    Optional<Person> handle(GetPersonByIdQuery query);
    Optional<Person> handle(GetPersonByEmailQuery query);
    List<Person> handle(GetAllPersonsQuery query);
}
