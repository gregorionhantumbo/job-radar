package com.gregorio.job_radar.modules.users.application.usecaseimpl.skill;

import com.gregorio.job_radar.modules.users.application.dto.SkillOutput;
import com.gregorio.job_radar.modules.users.application.repository.SkillRepository;
import com.gregorio.job_radar.modules.users.application.usecase.skill.GetSkillByIdUseCase;
import com.gregorio.job_radar.modules.users.domain.Skill;
import com.gregorio.job_radar.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetSkillByIdUseCaseImpl implements GetSkillByIdUseCase {

    private final SkillRepository skillRepository;

    public GetSkillByIdUseCaseImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public SkillOutput execute(UUID uuid) {
        Skill skill = skillRepository.findByUuid(uuid)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Skill not found: " + uuid
                        )
                );

        return new SkillOutput(
                skill.getUuid(),
                skill.getSkillName(),
                skill.getLevel()
        );
    }
}