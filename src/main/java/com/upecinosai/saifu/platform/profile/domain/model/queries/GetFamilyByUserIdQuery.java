package com.upecinosai.saifu.platform.profile.domain.model.queries;

public record GetFamilyByUserIdQuery(Long userId) {
    public GetFamilyByUserIdQuery {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
    }
}
