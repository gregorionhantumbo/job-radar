package com.gregorio.job_radar.modules.users.api.dto;

import java.util.UUID;

public record SetFavoriteResponse(
        UUID userId,
        UUID jobId
) {
}