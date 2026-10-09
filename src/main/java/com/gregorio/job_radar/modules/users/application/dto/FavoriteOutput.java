package com.gregorio.job_radar.modules.users.application.dto;

import java.util.UUID;

public record FavoriteOutput(
        UUID userId,
        UUID jobId
) {
}