
package com.gregorio.job_radar.modules.users.application.usecaseimpl.skill;

import com.gregorio.job_radar.modules.users.application.dto.CreateSkillInput;
import com.gregorio.job_radar.modules.users.application.dto.SkillOutput;
import com.gregorio.job_radar.modules.users.application.repository.SkillRepository;
import com.gregorio.job_radar.modules.users.application.usecase.skill.CreateSkillUseCase;
import com.gregorio.job_radar.modules.users.domain.Skill;
import com.gregorio.job_radar.shared.exception.DuplicateResourceException;

public class CreateSkillUseCaseImpl implements CreateSkillUseCase {

    private final SkillRepository skillRepository;

    public CreateSkillUseCaseImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillOutput execute(CreateSkillInput input) {

        if (skillRepository.existsBySkillName(input.skillName())) {
            throw new DuplicateResourceException(
                    "Skill already exists: " + input.skillName()
            );
        }

        Skill skill = new Skill(
                null,
                input.skillName(),
                input.level()
        );

        Skill saved = skillRepository.save(skill);

        return new SkillOutput(
                saved.getUuid(),
                saved.getSkillName(),
                saved.getLevel()
        );
    }
}