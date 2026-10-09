
package com.gregorio.job_radar.modules.users.api.dto;

import com.gregorio.job_radar.modules.users.domain.SkillLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateSkillRequest(
        @NotBlank(message = "O nome da skill é obrigatório.")
        @Size(min = 2, max = 80, message = "O nome da skill deve ter entre 2 e 80 caracteres.")
        String skillName,
        @NotNull(message = "O nível da skill é obrigatório.")
        SkillLevel level
) {
}