package com.upecinosai.saifu.platform.profile.domain.model.queries;

public record GetPlanByUserIdQuery(Long userId) {
    public GetPlanByUserIdQuery {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("User ID must be greater than 0");
        }
    }
}
