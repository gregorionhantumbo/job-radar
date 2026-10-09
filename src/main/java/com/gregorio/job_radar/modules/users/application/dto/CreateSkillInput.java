
package com.gregorio.job_radar.modules.users.application.dto;

import com.gregorio.job_radar.modules.users.domain.SkillLevel;

public record CreateSkillInput(
        String skillName,
        SkillLevel level
) {
}