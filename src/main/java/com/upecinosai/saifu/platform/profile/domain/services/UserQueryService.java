package com.upecinosai.saifu.platform.profile.domain.services;

import com.upecinosai.saifu.platform.profile.domain.model.entities.User;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetAllUsersQuery;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
}
