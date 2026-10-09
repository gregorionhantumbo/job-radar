package com.gregorio.job_radar.modules.users.infrastructure.repository;

import com.gregorio.job_radar.modules.users.application.repository.UserRepository;
import com.gregorio.job_radar.modules.users.domain.User;
import com.gregorio.job_radar.modules.users.infrastructure.entity.UserEntity;
import com.gregorio.job_radar.modules.users.infrastructure.mapper.UserEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(
            UserJpaRepository userJpaRepository
    ) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User save(User user) {

        UserEntity entity =
                UserEntityMapper.toEntity(user);

        UserEntity savedEntity =
                userJpaRepository.save(entity);

        return UserEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findByUuid(UUID uuid) {

        return userJpaRepository
                .findById(uuid)
                .filter(entity -> !entity.isDeleted())
                .map(UserEntityMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {

        return userJpaRepository
                .existsByEmailAndDeletedFalse(email);
    }

    @Override
    public boolean existsByUsername(String username) {

        return userJpaRepository
                .existsByUsernameAndDeletedFalse(username);
    }

    @Override
    public List<User> findAll() {

        return userJpaRepository
                .findAllByDeletedFalse()
                .stream()
                .map(UserEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<User> findAllDeleted() {

        return userJpaRepository
                .findAllByDeletedTrue()
                .stream()
                .map(UserEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<UUID> findFavoriteJobIds(UUID userId) {

        return userJpaRepository
                .findById(userId)
                .filter(entity -> !entity.isDeleted())
                .map(UserEntity::getFavoriteJobIds)
                .map(List::copyOf)
                .orElse(List.of());
    }
}