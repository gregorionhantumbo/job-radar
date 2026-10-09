
package com.gregorio.job_radar.modules.users.application.usecaseimpl.skill;

import com.gregorio.job_radar.modules.users.application.dto.SkillOutput;
import com.gregorio.job_radar.modules.users.application.dto.UpdateSkillInput;
import com.gregorio.job_radar.modules.users.application.repository.SkillRepository;
import com.gregorio.job_radar.modules.users.application.usecase.skill.UpdateSkillUseCase;
import com.gregorio.job_radar.modules.users.domain.Skill;

public class UpdateSkillUseCaseImpl implements UpdateSkillUseCase {

    private final SkillRepository skillRepository;

    public UpdateSkillUseCaseImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillOutput execute(UpdateSkillInput input) {

        Skill skill = skillRepository
                .findByUuid(input.uuid())
                .orElseThrow(() ->
                        new IllegalArgumentException("Skill not found")
                );

        skill.setSkillName(input.skillName());
        skill.setLevel(input.level());

        Skill updated = skillRepository.save(skill);

        return new SkillOutput(
                updated.getUuid(),
                updated.getSkillName(),
                updated.getLevel()
        );
    }
}