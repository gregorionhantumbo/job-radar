package com.gregorio.job_radar.modules.users.application.usecase.skill;

import com.gregorio.job_radar.modules.users.application.dto.SkillOutput;

import java.util.List;

public interface GetSkillsUseCase {

    List<SkillOutput> execute();
}