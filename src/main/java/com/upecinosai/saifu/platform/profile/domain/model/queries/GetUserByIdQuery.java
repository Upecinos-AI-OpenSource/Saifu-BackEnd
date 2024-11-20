package com.upecinosai.saifu.platform.profile.domain.model.queries;

public record GetUserByIdQuery(Long id) {
    public GetUserByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }
}
