package com.gregorio.job_radar.modules.users.application.usecase.user;

import com.gregorio.job_radar.modules.users.application.dto.UserOutput;

import java.util.List;

public interface GetDeletedUsersUseCase {

    List<UserOutput> execute();
}