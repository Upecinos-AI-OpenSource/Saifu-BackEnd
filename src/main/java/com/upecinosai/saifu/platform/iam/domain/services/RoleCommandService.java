package com.upecinosai.saifu.platform.iam.domain.services;

import com.upecinosai.saifu.platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
