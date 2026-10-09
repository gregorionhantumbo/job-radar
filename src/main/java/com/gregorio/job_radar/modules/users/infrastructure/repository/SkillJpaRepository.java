package com.gregorio.job_radar.modules.users.infrastructure.repository;

import com.gregorio.job_radar.modules.users.infrastructure.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SkillJpaRepository
        extends JpaRepository<SkillEntity, UUID> {

    Optional<SkillEntity> findByUuidAndDeletedFalse(UUID uuid);

    Optional<SkillEntity> findBySkillNameIgnoreCaseAndDeletedFalse(
            String skillName
    );

    boolean existsBySkillNameIgnoreCaseAndDeletedFalse(
            String skillName
    );

    List<SkillEntity> findAllByDeletedFalse();

    List<SkillEntity> findAllByDeletedTrue();
}