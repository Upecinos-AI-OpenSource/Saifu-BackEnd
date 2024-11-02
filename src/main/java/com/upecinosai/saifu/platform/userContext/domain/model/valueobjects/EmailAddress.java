package com.upecinosai.saifu.platform.userContext.domain.model.valueobjects;


import javax.persistence.*;
import javax.validation.constraints.Email;

@Embeddable
public record EmailAddress(@Email String address) {
    public EmailAddress() {
        this(null);
    }
}

