package com.upecinosai.saifu.platform.userContext.domain.model.valueobjects;


import javax.persistence.*;

@Embeddable
public record PersonName(String firstName, String lastName) {
    public PersonName() {
        this(null, null);
    }

    public String getFullName() {
        return String.format("%s, %s", firstName, lastName);
    }

    public PersonName {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }

    }
}