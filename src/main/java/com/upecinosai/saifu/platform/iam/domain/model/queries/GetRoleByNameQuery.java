package com.upecinosai.saifu.platform.iam.domain.model.queries;

import com.upecinosai.saifu.platform.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles roleName) {
}
