package com.gregorio.job_radar.modules.users.application.usecase.user;

import com.gregorio.job_radar.modules.users.application.dto.UpdateUserInput;
import com.gregorio.job_radar.modules.users.application.dto.UserOutput;

public interface UpdateUserUseCase {

    UserOutput execute(UpdateUserInput input);
}