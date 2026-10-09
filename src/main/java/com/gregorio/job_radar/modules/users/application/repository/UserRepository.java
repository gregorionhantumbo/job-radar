package com.gregorio.job_radar.modules.users.application.repository;

import com.gregorio.job_radar.modules.users.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    User save(User user);

    Optional<User> findByUuid(UUID uuid);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    List<User> findAll();

    List<User> findAllDeleted();

    List<UUID> findFavoriteJobIds(UUID userId);
}