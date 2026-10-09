package com.gregorio.job_radar.modules.users.application.usecase.user;


import java.util.UUID;

public interface RemoveFavoriteUseCase {

    void execute(UUID userId, UUID jobId);
}