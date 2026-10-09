package com.gregorio.job_radar.modules.users.api.controller;

import com.gregorio.job_radar.modules.users.api.dto.CreateSkillRequest;
import com.gregorio.job_radar.modules.users.api.dto.SkillResponse;
import com.gregorio.job_radar.modules.users.api.dto.UpdateSkillRequest;
import com.gregorio.job_radar.modules.users.application.dto.CreateSkillInput;
import com.gregorio.job_radar.modules.users.application.dto.SkillOutput;
import com.gregorio.job_radar.modules.users.application.dto.UpdateSkillInput;
import com.gregorio.job_radar.modules.users.application.usecase.skill.CreateSkillUseCase;
import com.gregorio.job_radar.modules.users.application.usecase.skill.DeleteSkillUseCase;
import com.gregorio.job_radar.modules.users.application.usecase.skill.GetDeletedSkillsUseCase;
import com.gregorio.job_radar.modules.users.application.usecase.skill.GetSkillByIdUseCase;
import com.gregorio.job_radar.modules.users.application.usecase.skill.GetSkillsUseCase;
import com.gregorio.job_radar.modules.users.application.usecase.skill.UpdateSkillUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.prefix}/skills")
public class SkillController {

    private final CreateSkillUseCase createSkillUseCase;
    private final UpdateSkillUseCase updateSkillUseCase;
    private final DeleteSkillUseCase deleteSkillUseCase;
    private final GetSkillsUseCase getSkillsUseCase;
    private final GetDeletedSkillsUseCase getDeletedSkillsUseCase;
    private final GetSkillByIdUseCase getSkillByIdUseCase;

    public SkillController(
            CreateSkillUseCase createSkillUseCase,
            UpdateSkillUseCase updateSkillUseCase,
            DeleteSkillUseCase deleteSkillUseCase,
            GetSkillsUseCase getSkillsUseCase,
            GetDeletedSkillsUseCase getDeletedSkillsUseCase,
            GetSkillByIdUseCase getSkillByIdUseCase
    ) {
        this.createSkillUseCase = createSkillUseCase;
        this.updateSkillUseCase = updateSkillUseCase;
        this.deleteSkillUseCase = deleteSkillUseCase;
        this.getSkillsUseCase = getSkillsUseCase;
        this.getDeletedSkillsUseCase = getDeletedSkillsUseCase;
        this.getSkillByIdUseCase = getSkillByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<SkillResponse>> findAll() {
        List<SkillResponse> skills = getSkillsUseCase.execute()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(skills);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<SkillResponse> findByUuid(
            @PathVariable UUID uuid
    ) {
        return ResponseEntity.ok(
                toResponse(getSkillByIdUseCase.execute(uuid))
        );
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<SkillResponse>> findAllDeleted() {
        List<SkillResponse> skills = getDeletedSkillsUseCase.execute()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(skills);
    }

    @PostMapping
    public ResponseEntity<SkillResponse> create(
            @Valid @RequestBody CreateSkillRequest request
    ) {
        CreateSkillInput input = new CreateSkillInput(
                request.skillName(),
                request.level()
        );

        SkillOutput output = createSkillUseCase.execute(input);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{uuid}")
                .buildAndExpand(output.uuid())
                .toUri();

        return ResponseEntity.created(location)
                .body(toResponse(output));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<SkillResponse> update(
            @PathVariable UUID uuid,
            @Valid @RequestBody UpdateSkillRequest request
    ) {
        UpdateSkillInput input = new UpdateSkillInput(
                uuid,
                request.skillName(),
                request.level()
        );

        return ResponseEntity.ok(
                toResponse(updateSkillUseCase.execute(input))
        );
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        deleteSkillUseCase.execute(uuid);
        return ResponseEntity.noContent().build();
    }

    private SkillResponse toResponse(SkillOutput output) {
        return new SkillResponse(
                output.uuid(),
                output.skillName(),
                output.level()
        );
    }
}