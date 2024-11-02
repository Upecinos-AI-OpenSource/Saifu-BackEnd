package com.upecinosai.saifu.platform.userContext.domain.model.queries;

import com.upecinosai.saifu.platform.userContext.domain.model.valueobjects.EmailAddress;

public record GetPersonByEmailQuery(EmailAddress emailAddress) {
}
