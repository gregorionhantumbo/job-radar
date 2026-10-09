package com.gregorio.job_radar.modules.users.application.usecase.skill;

import com.gregorio.job_radar.modules.users.application.dto.CreateSkillInput;
import com.gregorio.job_radar.modules.users.application.dto.SkillOutput;

public interface CreateSkillUseCase {

    SkillOutput execute(CreateSkillInput input);
}