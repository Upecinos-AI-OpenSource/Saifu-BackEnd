package com.upecinosai.saifu.platform.finantialEducation.interfaces.rest;

import com.upecinosai.saifu.platform.finantialEducation.aplication.internal.commandservices.FinantialEducationCommandService;
import com.upecinosai.saifu.platform.finantialEducation.aplication.internal.queryservices.FinantialEducationQueryService;
import com.upecinosai.saifu.platform.finantialEducation.domain.model.FinantialEducation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finantial-education")
public class FinantialEducationController {

    private final FinantialEducationCommandService commandService;
    private final FinantialEducationQueryService queryService;

    public FinantialEducationController(FinantialEducationCommandService commandService, FinantialEducationQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @GetMapping
    public List<FinantialEducation> getAll() {
        return queryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinantialEducation> getById(@PathVariable Long id) {
        return queryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FinantialEducation create(@RequestBody FinantialEducation finantialEducation) {
        return commandService.save(finantialEducation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinantialEducation> update(@PathVariable Long id, @RequestBody FinantialEducation updatedEducation) {
        return queryService.findById(id)
                .map(existing -> {
                    existing.setTitulo(updatedEducation.getTitulo());
                    existing.setIdRespuesta(updatedEducation.getIdRespuesta());
                    existing.setIdPreguntas(updatedEducation.getIdPreguntas());
                    return ResponseEntity.ok(commandService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (queryService.findById(id).isPresent()) {
            commandService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
