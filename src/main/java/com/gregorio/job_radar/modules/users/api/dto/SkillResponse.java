
package com.gregorio.job_radar.modules.users.api.dto;

import com.gregorio.job_radar.modules.users.domain.SkillLevel;

import java.util.UUID;

public record SkillResponse(
        UUID uuid,
        String skillName,
        SkillLevel level
) {
}