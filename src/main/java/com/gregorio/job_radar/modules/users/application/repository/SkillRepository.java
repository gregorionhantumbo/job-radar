package com.gregorio.job_radar.modules.users.application.repository;

import com.gregorio.job_radar.modules.users.domain.Skill;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SkillRepository {

    Skill save(Skill skill);

    Optional<Skill> findByUuid(UUID uuid);

    Optional<Skill> findBySkillName(String skillName);

    boolean existsBySkillName(String skillName);

    List<Skill> findAll();

    List<Skill> findAllDeleted();
}