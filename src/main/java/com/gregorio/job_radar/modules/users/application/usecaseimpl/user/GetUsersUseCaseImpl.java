package com.gregorio.job_radar.modules.users.application.usecaseimpl.user;

import com.gregorio.job_radar.modules.users.application.dto.UserOutput;
import com.gregorio.job_radar.modules.users.application.mapper.UserMapper;
import com.gregorio.job_radar.modules.users.application.repository.UserRepository;
import com.gregorio.job_radar.modules.users.application.usecase.user.GetUsersUseCase;

import java.util.List;

public class GetUsersUseCaseImpl implements GetUsersUseCase {

    private final UserRepository userRepository;

    public GetUsersUseCaseImpl(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserOutput> execute() {

        return userRepository
                .findAll()
                .stream()
                .map(UserMapper::toOutput)
                .toList();
    }
}