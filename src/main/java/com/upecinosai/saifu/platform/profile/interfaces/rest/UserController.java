package com.upecinosai.saifu.platform.profile.interfaces.rest;

import com.upecinosai.saifu.platform.profile.domain.model.entities.User;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetAllUsersQuery;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetUserByIdQuery;
import com.upecinosai.saifu.platform.profile.domain.services.UserCommandService;
import com.upecinosai.saifu.platform.profile.domain.services.UserQueryService;
import com.upecinosai.saifu.platform.profile.interfaces.rest.resources.CreateUserResource;
import com.upecinosai.saifu.platform.profile.interfaces.rest.resources.UserResource;
import com.upecinosai.saifu.platform.profile.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import com.upecinosai.saifu.platform.profile.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/users", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "Operations related to users")
public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserController(final UserCommandService userCommandService, final UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @Operation(
            summary = "Create a User",
            description = "Create a User"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        Optional<User> user = userCommandService.handle(CreateUserCommandFromResourceAssembler.toCommandFromResource(resource));
        return user.map(source -> new ResponseEntity<>(UserResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Get all users", description = "Retrieve a list of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    })
    @GetMapping
    public ResponseEntity<List<UserResource>> getAllUsers() {
        List<User> users = userQueryService.handle(new GetAllUsersQuery());
        List<UserResource> resources = users.stream()
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get user by ID", description = "Retrieve a user by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long id) {
        Optional<User> user = userQueryService.handle(new GetUserByIdQuery(id));
        return user.map(value -> ResponseEntity.ok(UserResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
