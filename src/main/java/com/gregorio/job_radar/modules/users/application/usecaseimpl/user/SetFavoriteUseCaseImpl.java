package com.gregorio.job_radar.modules.users.application.usecaseimpl.user;

import com.gregorio.job_radar.modules.users.application.dto.FavoriteOutput;
import com.gregorio.job_radar.modules.users.application.repository.UserRepository;
import com.gregorio.job_radar.modules.users.application.usecase.user.SetFavoriteUseCase;
import com.gregorio.job_radar.modules.users.domain.User;

import java.util.UUID;

public class SetFavoriteUseCaseImpl implements SetFavoriteUseCase {

    private final UserRepository userRepository;

    public SetFavoriteUseCaseImpl(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public FavoriteOutput setFavorite(
            UUID userId,
            UUID jobId
    ) {

        User user = userRepository.findByUuid(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found: " + userId
                        )
                );

        user.addFavoriteJob(jobId);

        User savedUser = userRepository.save(user);

        return new FavoriteOutput(
                savedUser.getUuid(),
                jobId
        );
    }
}