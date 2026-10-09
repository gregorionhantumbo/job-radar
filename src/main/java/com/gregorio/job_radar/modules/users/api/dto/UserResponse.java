package com.gregorio.job_radar.modules.users.api.dto;

import java.util.Set;
import java.util.UUID;

public record UserResponse(
        UUID uuid,
        String fullName,
        String username,
        String contact,
        String title,
        String email,
        Set<String> skills
) {
}