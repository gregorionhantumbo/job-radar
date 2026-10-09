package com.gregorio.job_radar.modules.users.application.usecase.user;

import java.util.UUID;

public interface DeleteUserUseCase {

    void execute(UUID uuid);
}