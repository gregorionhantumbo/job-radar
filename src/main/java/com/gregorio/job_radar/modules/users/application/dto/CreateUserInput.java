package com.gregorio.job_radar.modules.users.application.dto;

import java.util.Set;

public record CreateUserInput(
        String fullName,
        String username,
        String password,
        String contact,
        String title,
        String email,
        Set<String> skills
) {
}