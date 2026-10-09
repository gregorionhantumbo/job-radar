package com.gregorio.job_radar.modules.users.application.usecaseimpl.user;

import com.gregorio.job_radar.modules.users.application.dto.UserOutput;
import com.gregorio.job_radar.modules.users.application.mapper.UserMapper;
import com.gregorio.job_radar.modules.users.application.repository.UserRepository;
import com.gregorio.job_radar.modules.users.application.usecase.user.GetDeletedUsersUseCase;

import java.util.List;

public class GetDeletedUsersUseCaseImpl implements GetDeletedUsersUseCase {

    private final UserRepository userRepository;

    public GetDeletedUsersUseCaseImpl(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserOutput> execute() {

        return userRepository
                .findAllDeleted()
                .stream()
                .map(UserMapper::toOutput)
                .toList();
    }
}