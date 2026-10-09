package com.gregorio.job_radar.modules.users.application.usecaseimpl.user;

import com.gregorio.job_radar.modules.users.application.repository.UserRepository;
import com.gregorio.job_radar.modules.users.application.usecase.user.RemoveFavoriteUseCase;
import com.gregorio.job_radar.modules.users.domain.User;
import com.gregorio.job_radar.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RemoveFavoriteUseCaseImpl implements RemoveFavoriteUseCase {

    private final UserRepository userRepository;

    public RemoveFavoriteUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute(UUID userId, UUID jobId) {
        User user = userRepository.findByUuid(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found: " + userId
                        )
                );

        user.removeFavoriteJob(jobId);

        userRepository.save(user);
    }
}