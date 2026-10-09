package com.gregorio.job_radar.modules.users.application.usecase.skill;

import com.gregorio.job_radar.modules.users.application.dto.SkillOutput;
import com.gregorio.job_radar.modules.users.application.dto.UpdateSkillInput;

public interface UpdateSkillUseCase {

    SkillOutput execute(UpdateSkillInput input);
}