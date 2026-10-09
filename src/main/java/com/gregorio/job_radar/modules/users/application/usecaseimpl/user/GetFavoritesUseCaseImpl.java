package com.gregorio.job_radar.modules.users.application.usecaseimpl.user;


import com.gregorio.job_radar.modules.users.application.repository.UserRepository;
import com.gregorio.job_radar.modules.users.application.usecase.user.GetFavoritesUseCase;
import com.gregorio.job_radar.modules.users.domain.User;
import com.gregorio.job_radar.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetFavoritesUseCaseImpl implements GetFavoritesUseCase {

    private final UserRepository userRepository;

    public GetFavoritesUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UUID> execute(UUID userId) {
        User user = userRepository.findByUuid(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found: " + userId
                        )
                );

        return user.getFavoriteJobIds()
                .stream()
                .toList();
    }
}