package com.gregorio.job_radar.modules.users.infrastructure.mapper;

import com.gregorio.job_radar.modules.users.domain.Skill;
import com.gregorio.job_radar.modules.users.domain.User;
import com.gregorio.job_radar.modules.users.infrastructure.entity.SkillEntity;
import com.gregorio.job_radar.modules.users.infrastructure.entity.UserEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class UserEntityMapper {

    private UserEntityMapper() {
    }

    public static UserEntity toEntity(User user) {

        UserEntity entity = new UserEntity();

        entity.setUuid(user.getUuid());
        entity.setFullName(user.getFullName());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setContact(user.getContact());
        entity.setTitle(user.getTitle());
        entity.setEmail(user.getEmail());
        entity.setDeleted(user.isDeleted());

        Set<SkillEntity> skills = user.getSkills()
                .stream()
                .map(SkillEntityMapper::toEntity)
                .collect(Collectors.toSet());

        entity.setSkills(skills);

        entity.setFavoriteJobIds(
                new HashSet<>(user.getFavoriteJobIds())
        );

        return entity;
    }

    public static User toDomain(UserEntity entity) {

        Set<Skill> skills = entity.getSkills()
                .stream()
                .map(SkillEntityMapper::toDomain)
                .collect(Collectors.toSet());

        User user = new User(
                entity.getUuid(),
                entity.getFullName(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getContact(),
                entity.getTitle(),
                entity.getEmail(),
                skills
        );

        user.setFavoriteJobIds(
                new HashSet<>(entity.getFavoriteJobIds())
        );

        if (entity.isDeleted()) {
            user.delete();
        }

        return user;
    }
}