package com.gregorio.job_radar.modules.users.application.usecase.user;

import com.gregorio.job_radar.modules.users.application.dto.CreateUserInput;
import com.gregorio.job_radar.modules.users.application.dto.UserOutput;

public interface CreateUserUseCase {

    UserOutput execute(CreateUserInput input);
}