package com.gregorio.job_radar.modules.users.application.usecaseimpl.skill;

import com.gregorio.job_radar.modules.users.application.dto.SkillOutput;
import com.gregorio.job_radar.modules.users.application.repository.SkillRepository;
import com.gregorio.job_radar.modules.users.application.usecase.skill.GetSkillsUseCase;
import com.gregorio.job_radar.modules.users.domain.Skill;

import java.util.List;

public class GetSkillsUseCaseImpl implements GetSkillsUseCase {

    private final SkillRepository skillRepository;

    public GetSkillsUseCaseImpl(
            SkillRepository skillRepository
    ) {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<SkillOutput> execute() {

        return skillRepository
                .findAll()
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