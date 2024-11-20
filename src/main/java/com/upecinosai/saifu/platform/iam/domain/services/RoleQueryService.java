package com.upecinosai.saifu.platform.iam.domain.services;

import com.upecinosai.saifu.platform.iam.domain.model.entities.Role;
import com.upecinosai.saifu.platform.iam.domain.model.queries.GetAllRolesQuery;
import com.upecinosai.saifu.platform.iam.domain.model.queries.GetRolesByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRolesByNameQuery query);
}
