package com.upecinosai.saifu.platform.profile.domain.model.valueObjects;

import lombok.Value;

import javax.persistence.Embeddable;

@Value
@Embeddable
public class PhoneNumber {
    String value;

    public PhoneNumber() {
        this.value = "";
    }

    public PhoneNumber(String value) {
        if (!value.matches("\\+?[0-9]{10,15}")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        this.value = value;
    }
}
