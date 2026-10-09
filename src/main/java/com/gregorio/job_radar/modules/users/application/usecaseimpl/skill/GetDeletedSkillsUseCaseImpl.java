package com.gregorio.job_radar.modules.users.application.usecaseimpl.skill;

import com.gregorio.job_radar.modules.users.application.dto.SkillOutput;
import com.gregorio.job_radar.modules.users.application.repository.SkillRepository;
import com.gregorio.job_radar.modules.users.application.usecase.skill.GetDeletedSkillsUseCase;
import com.gregorio.job_radar.modules.users.domain.Skill;

import java.util.List;

public class GetDeletedSkillsUseCaseImpl
        implements GetDeletedSkillsUseCase {

    private final SkillRepository skillRepository;

    public GetDeletedSkillsUseCaseImpl(
            SkillRepository skillRepository
    ) {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<SkillOutput> execute() {

        return skillRepository
                .findAllDeleted()
                .stream()
                .map(this::toOutput)
                .toList();
    }

    private SkillOutput toOutput(Skill skill) {

        return new SkillOutput(
                skill.getUuid(),
                skill.getSkillName(),
                skill.getLevel()
        );
    }
}