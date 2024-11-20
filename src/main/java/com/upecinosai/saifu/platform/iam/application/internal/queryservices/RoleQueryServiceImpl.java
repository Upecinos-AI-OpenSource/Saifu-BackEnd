package com.upecinosai.saifu.platform.iam.application.internal.queryservices;

import com.upecinosai.saifu.platform.iam.domain.model.entities.Role;
import com.upecinosai.saifu.platform.iam.domain.model.queries.GetAllRolesQuery;
import com.upecinosai.saifu.platform.iam.domain.model.queries.GetRolesByNameQuery;
import com.upecinosai.saifu.platform.iam.domain.services.RoleQueryService;
import com.upecinosai.saifu.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleQueryServiceImpl implements RoleQueryService {

    private final RoleRepository roleRepository;

    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> handle(GetRolesByNameQuery query) {
        return roleRepository.findByName(query.name());
    }
}