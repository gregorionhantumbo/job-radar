package com.gregorio.job_radar.modules.users.application.mapper;

import com.gregorio.job_radar.modules.users.application.dto.CreateUserInput;
import com.gregorio.job_radar.modules.users.application.dto.UserOutput;
import com.gregorio.job_radar.modules.users.domain.Skill;
import com.gregorio.job_radar.modules.users.domain.User;

import java.util.Set;
import java.util.stream.Collectors;

public final class UserMapper {

    private UserMapper() {
    }

    public static User toDomain(
            CreateUserInput input,
            Set<Skill> skills
    ) {

        return new User(
                null,
                input.fullName(),
                input.username(),
                input.password(),
                input.contact(),
                input.title(),
                input.email(),
                skills
        );
    }

    public static UserOutput toOutput(User user) {

        Set<String> skills = user.getSkills()
                .stream()
                .map(Skill::getSkillName)
                .collect(Collectors.toSet());

        return new UserOutput(
                user.getUuid(),
                user.getFullName(),
                user.getUsername(),
                user.getContact(),
                user.getTitle(),
                user.getEmail(),
                skills
        );
    }
}