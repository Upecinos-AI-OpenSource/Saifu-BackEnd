package com.upecinosai.saifu.platform.profile.interfaces.rest;

import com.upecinosai.saifu.platform.profile.domain.model.aggregates.Family;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetAllFamiliesQuery;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetFamilyByIdQuery;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetFamilyByUserIdQuery;
import com.upecinosai.saifu.platform.profile.domain.services.FamilyCommandService;
import com.upecinosai.saifu.platform.profile.domain.services.FamilyQueryService;
import com.upecinosai.saifu.platform.profile.interfaces.rest.resources.CreateFamilyResource;
import com.upecinosai.saifu.platform.profile.interfaces.rest.resources.FamilyResource;
import com.upecinosai.saifu.platform.profile.interfaces.rest.transform.CreateFamilyCommandFromResourceAssembler;
import com.upecinosai.saifu.platform.profile.interfaces.rest.transform.FamilyResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/families", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Families", description = "Operations related to families")
public class FamilyController {
    private final FamilyCommandService familyCommandService;
    private final FamilyQueryService familyQueryService;

    public FamilyController(final FamilyCommandService familyCommandService, final FamilyQueryService familyQueryService) {
        this.familyCommandService = familyCommandService;
        this.familyQueryService = familyQueryService;
    }

    @Operation(
            summary = "Create a Family",
            description = "Create a new family associated with a user"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Family created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    @PostMapping
    public ResponseEntity<FamilyResource> createFamily(@RequestBody CreateFamilyResource resource) {
        Optional<Family> family = familyCommandService.handle(CreateFamilyCommandFromResourceAssembler.toCommandFromResource(resource));
        return family.map(f -> ResponseEntity.created(URI.create("/api/v1/families/" + f.getFAMILY_ID()))
                        .body(FamilyResourceFromEntityAssembler.toResourceFromEntity(f)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Get all families", description = "Retrieve all families")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Families retrieved"),
            @ApiResponse(responseCode = "404", description = "No families found")
    })
    @GetMapping
    public ResponseEntity<List<FamilyResource>> getAllFamilies() {
        List<Family> families = familyQueryService.handle(new GetAllFamiliesQuery());
        if (families.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<FamilyResource> resources = families.stream()
                .map(FamilyResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get family by ID", description = "Retrieve a family by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Family retrieved"),
            @ApiResponse(responseCode = "404", description = "Family not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<FamilyResource> getFamilyById(@PathVariable Long id) {
        Optional<Family> family = familyQueryService.handle(new GetFamilyByIdQuery(id));
        return family.map(f -> ResponseEntity.ok(FamilyResourceFromEntityAssembler.toResourceFromEntity(f)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get families by user ID", description = "Retrieve all families associated with a user ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Families retrieved"),
            @ApiResponse(responseCode = "404", description = "Families not found")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FamilyResource>> getFamiliesByUserId(@PathVariable Long userId) {
        List<Family> families = familyQueryService.handle(new GetFamilyByUserIdQuery(userId));
        if (families.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<FamilyResource> resources = families.stream()
                .map(FamilyResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }
}
