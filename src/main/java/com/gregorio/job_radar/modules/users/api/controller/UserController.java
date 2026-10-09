package com.gregorio.job_radar.modules.users.api.controller;

import com.gregorio.job_radar.modules.users.api.dto.CreateUserRequest;
import com.gregorio.job_radar.modules.users.api.dto.UpdateUserRequest;
import com.gregorio.job_radar.modules.users.api.dto.UserResponse;
import com.gregorio.job_radar.modules.users.application.dto.CreateUserInput;
import com.gregorio.job_radar.modules.users.application.dto.UpdateUserInput;
import com.gregorio.job_radar.modules.users.application.dto.UserOutput;
import com.gregorio.job_radar.modules.users.application.usecase.user.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.prefix}/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final GetUsersUseCase getUsersUseCase;
    private final GetDeletedUsersUseCase getDeletedUsersUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final SetFavoriteUseCase setFavoriteUseCase;
    private final GetFavoritesUseCase getFavoritesUseCase;
    private final RemoveFavoriteUseCase removeFavoriteUseCase;

    public UserController(
            CreateUserUseCase createUserUseCase,
            UpdateUserUseCase updateUserUseCase,
            DeleteUserUseCase deleteUserUseCase,
            GetUsersUseCase getUsersUseCase,
            GetDeletedUsersUseCase getDeletedUsersUseCase,
            GetUserByIdUseCase getUserByIdUseCase,
            SetFavoriteUseCase setFavoriteUseCase,
            GetFavoritesUseCase getFavoritesUseCase,
            RemoveFavoriteUseCase removeFavoriteUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
        this.getDeletedUsersUseCase = getDeletedUsersUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.setFavoriteUseCase = setFavoriteUseCase;
        this.getFavoritesUseCase = getFavoritesUseCase;
        this.removeFavoriteUseCase = removeFavoriteUseCase;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> users = getUsersUseCase.execute()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserResponse> findByUuid(
            @PathVariable UUID uuid
    ) {
        return ResponseEntity.ok(
                toResponse(getUserByIdUseCase.execute(uuid))
        );
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<UserResponse>> findAllDeleted() {
        List<UserResponse> users = getDeletedUsersUseCase.execute()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(
            @Valid @RequestBody CreateUserRequest request
    ) {
        CreateUserInput input = new CreateUserInput(
                request.fullName(),
                request.username(),
                request.password(),
                request.contact(),
                request.title(),
                request.email(),
                request.skills()
        );

        UserOutput output = createUserUseCase.execute(input);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{uuid}")
                .buildAndExpand(output.uuid())
                .toUri();

        return ResponseEntity.created(location)
                .body(toResponse(output));
    }

    @GetMapping("/{userId}/favorites")
    public ResponseEntity<List<UUID>> findFavorites(
            @PathVariable UUID userId
    ) {
        return ResponseEntity.ok(
                getFavoritesUseCase.execute(userId)
        );
    }

    @DeleteMapping("/{userId}/favorites/{jobId}")
    public ResponseEntity<Void> removeFavorite(
            @PathVariable UUID userId,
            @PathVariable UUID jobId
    ) {
        removeFavoriteUseCase.execute(userId, jobId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<UserResponse> update(
            @PathVariable UUID uuid,
            @Valid @RequestBody UpdateUserRequest request
    ) {
        UpdateUserInput input = new UpdateUserInput(
                uuid,
                request.fullName(),
                request.username(),
                request.contact(),
                request.title(),
                request.email(),
                request.skills()
        );

        return ResponseEntity.ok(
                toResponse(updateUserUseCase.execute(input))
        );
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        deleteUserUseCase.execute(uuid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}/favorites/{jobId}")
    public ResponseEntity<?> addFavorite(
            @PathVariable UUID userId,
            @PathVariable UUID jobId
    ) {
        return ResponseEntity.ok(
                setFavoriteUseCase.setFavorite(userId, jobId)
        );
    }

    private UserResponse toResponse(UserOutput output) {
        return new UserResponse(
                output.uuid(),
                output.fullName(),
                output.username(),
                output.contact(),
                output.title(),
                output.email(),
                output.skills()
        );
    }
}