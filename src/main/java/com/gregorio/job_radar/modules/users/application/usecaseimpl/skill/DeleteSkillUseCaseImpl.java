package com.gregorio.job_radar.modules.users.application.usecaseimpl.skill;

import com.gregorio.job_radar.modules.users.application.repository.SkillRepository;
import com.gregorio.job_radar.modules.users.application.usecase.skill.DeleteSkillUseCase;
import com.gregorio.job_radar.modules.users.domain.Skill;

import java.util.UUID;

public class DeleteSkillUseCaseImpl implements DeleteSkillUseCase {

    private final SkillRepository skillRepository;

    public DeleteSkillUseCaseImpl(
            SkillRepository skillRepository
    ) {
        this.skillRepository = skillRepository;
    }

    @Override
    public void execute(UUID uuid) {

        Skill skill = skillRepository
                .findByUuid(uuid)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Skill not found"
                        )
                );

        skill.delete();

        skillRepository.save(skill);
    }
}