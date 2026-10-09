package com.gregorio.job_radar.modules.users.application.usecase.user;

import java.util.List;
import java.util.UUID;

public interface GetFavoritesUseCase {

    List<UUID> execute(UUID userId);
}