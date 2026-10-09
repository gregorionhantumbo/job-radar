package com.gregorio.job_radar.modules.users.infrastructure.repository;

import com.gregorio.job_radar.modules.users.application.repository.SkillRepository;
import com.gregorio.job_radar.modules.users.domain.Skill;
import com.gregorio.job_radar.modules.users.infrastructure.entity.SkillEntity;
import com.gregorio.job_radar.modules.users.infrastructure.mapper.SkillEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SkillRepositoryImpl implements SkillRepository {

    private final SkillJpaRepository skillJpaRepository;

    public SkillRepositoryImpl(
            SkillJpaRepository skillJpaRepository
    ) {
        this.skillJpaRepository = skillJpaRepository;
    }

    @Override
    public Skill save(Skill skill) {

        SkillEntity entity =
                SkillEntityMapper.toEntity(skill);

        SkillEntity savedEntity =
                skillJpaRepository.save(entity);

        return SkillEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Skill> findByUuid(UUID uuid) {

        return skillJpaRepository
                .findByUuidAndDeletedFalse(uuid)
                .map(SkillEntityMapper::toDomain);
    }

    @Override
    public Optional<Skill> findBySkillName(String skillName) {

        return skillJpaRepository
                .findBySkillNameIgnoreCaseAndDeletedFalse(skillName)
                .map(SkillEntityMapper::toDomain);
    }

    @Override
    public boolean existsBySkillName(String skillName) {

        return skillJpaRepository
                .existsBySkillNameIgnoreCaseAndDeletedFalse(skillName);
    }

    @Override
    public List<Skill> findAll() {

        return skillJpaRepository
                .findAllByDeletedFalse()
                .stream()
                .map(SkillEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Skill> findAllDeleted() {

        return skillJpaRepository
                .findAllByDeletedTrue()
                .stream()
                .map(SkillEntityMapper::toDomain)
                .toList();
    }
}