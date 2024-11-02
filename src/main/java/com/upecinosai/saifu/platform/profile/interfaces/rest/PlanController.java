package com.upecinosai.saifu.platform.profile.interfaces.rest;

import com.upecinosai.saifu.platform.profile.domain.model.aggregates.Plan;
import com.upecinosai.saifu.platform.profile.domain.model.commands.CreatePlanCommand;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetAllPlansQuery;
import com.upecinosai.saifu.platform.profile.domain.model.queries.GetPlanByUserIdQuery;
import com.upecinosai.saifu.platform.profile.domain.services.PlanCommandService;
import com.upecinosai.saifu.platform.profile.domain.services.PlanQueryService;
import com.upecinosai.saifu.platform.profile.interfaces.rest.resources.CreatePlanResource;
import com.upecinosai.saifu.platform.profile.interfaces.rest.resources.PlanResource;
import com.upecinosai.saifu.platform.profile.interfaces.rest.transform.CreatePlanCommandFromResourceAssembler;
import com.upecinosai.saifu.platform.profile.interfaces.rest.transform.PlanResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/plans", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Plans", description = "Operations related to plans")
public class PlanController {
    private final PlanCommandService planCommandService;
    private final PlanQueryService planQueryService;

    public PlanController(final PlanCommandService planCommandService, final PlanQueryService planQueryService) {
        this.planCommandService = planCommandService;
        this.planQueryService = planQueryService;
    }

    @Operation(
            summary = "Create a Plan",
            description = "Create a new plan associated with a user"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plan created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    @PostMapping
    public ResponseEntity<PlanResource> createPlan(@RequestBody CreatePlanResource resource) {
        CreatePlanCommand command = CreatePlanCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<Plan> plan = planCommandService.handle(command);

        return plan.map(p -> ResponseEntity.created(URI.create("/api/v1/plans/" + p.getPLANID()))
                        .body(PlanResourceFromEntityAssembler.toResourceFromEntity(p)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Get all plans", description = "Retrieve all plans")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plans retrieved"),
            @ApiResponse(responseCode = "404", description = "No plans found")
    })
    @GetMapping
    public ResponseEntity<List<PlanResource>> getAllPlans() {
        List<Plan> plans = planQueryService.handle(new GetAllPlansQuery());
        if (plans.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<PlanResource> resources = plans.stream()
                .map(PlanResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get plan by user ID", description = "Retrieve a plan by its user ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plan retrieved"),
            @ApiResponse(responseCode = "404", description = "Plan not found")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<PlanResource> getPlanByUserId(@PathVariable Long userId) {
        Optional<Plan> plan = planQueryService.handle(new GetPlanByUserIdQuery(userId));
        return plan.map(p -> ResponseEntity.ok(PlanResourceFromEntityAssembler.toResourceFromEntity(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
