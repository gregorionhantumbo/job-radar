
package com.gregorio.job_radar.modules.users.infrastructure.mapper;

import com.gregorio.job_radar.modules.users.domain.Skill;
import com.gregorio.job_radar.modules.users.infrastructure.entity.SkillEntity;

public final class SkillEntityMapper {

    private SkillEntityMapper() {
    }

    public static SkillEntity toEntity(Skill skill) {

        SkillEntity entity = new SkillEntity();

        entity.setUuid(skill.getUuid());
        entity.setSkillName(skill.getSkillName());
        entity.setLevel(skill.getLevel());
        entity.setDeleted(skill.isDeleted());

        return entity;
    }

    public static Skill toDomain(SkillEntity entity) {

        Skill skill = new Skill(
                entity.getUuid(),
                entity.getSkillName(),
                entity.getLevel()
        );

        if (entity.isDeleted()) {
            skill.delete();
        }

        return skill;
    }
}