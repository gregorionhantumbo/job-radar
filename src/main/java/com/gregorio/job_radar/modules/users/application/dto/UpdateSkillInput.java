
package com.gregorio.job_radar.modules.users.application.dto;

import com.gregorio.job_radar.modules.users.domain.SkillLevel;

import java.util.UUID;

public record UpdateSkillInput(
        UUID uuid,
        String skillName,
        SkillLevel level
) {
}