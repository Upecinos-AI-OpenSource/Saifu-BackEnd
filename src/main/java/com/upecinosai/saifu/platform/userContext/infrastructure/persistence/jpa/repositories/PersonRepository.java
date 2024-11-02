package com.upecinosai.saifu.platform.userContext.infrastructure.persistence.jpa.repositories;

import com.upecinosai.saifu.platform.userContext.domain.model.aggregates.Person;
import com.upecinosai.saifu.platform.userContext.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(EmailAddress emailAddress);
    boolean existsByEmail(EmailAddress emailAddress);
}
