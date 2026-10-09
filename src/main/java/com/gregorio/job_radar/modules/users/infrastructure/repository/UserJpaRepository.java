package com.gregorio.job_radar.modules.users.infrastructure.repository;

import com.gregorio.job_radar.modules.users.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository
        extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmailAndDeletedFalse(String email);

    boolean existsByEmailAndDeletedFalse(String email);

    boolean existsByUsernameAndDeletedFalse(String username);

    List<UserEntity> findAllByDeletedFalse();

    List<UserEntity> findAllByDeletedTrue();
}