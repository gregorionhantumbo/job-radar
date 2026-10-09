package com.gregorio.job_radar.modules.users.application.usecase.user;

import com.gregorio.job_radar.modules.users.application.dto.FavoriteOutput;

import java.util.UUID;

public interface SetFavoriteUseCase {

 FavoriteOutput setFavorite(UUID userId, UUID jobId);
}