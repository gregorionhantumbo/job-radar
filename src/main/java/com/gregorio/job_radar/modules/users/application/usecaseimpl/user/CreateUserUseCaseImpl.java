package com.gregorio.job_radar.modules.users.application.usecaseimpl.user;

import com.gregorio.job_radar.modules.users.application.dto.CreateUserInput;
import com.gregorio.job_radar.modules.users.application.dto.UserOutput;
import com.gregorio.job_radar.modules.users.application.mapper.UserMapper;
import com.gregorio.job_radar.modules.users.application.repository.SkillRepository;
import com.gregorio.job_radar.modules.users.application.repository.UserRepository;
import com.gregorio.job_radar.modules.users.application.usecase.user.CreateUserUseCase;
import com.gregorio.job_radar.modules.users.domain.Skill;
import com.gregorio.job_radar.modules.users.domain.User;
import com.gregorio.job_radar.shared.exception.DuplicateResourceException;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;
    private final SkillRepository skillRepository;

    public CreateUserUseCaseImpl(
            UserRepository userRepository,
            SkillRepository skillRepository
    ) {
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public UserOutput execute(CreateUserInput input) {

        if (userRepository.existsByUsername(input.username())) {
            throw new DuplicateResourceException(
                    "Username already exists: " + input.username()
            );
        }

        if (userRepository.existsByEmail(input.email())) {
            throw new DuplicateResourceException(
                    "Email already exists: " + input.email()
            );
        }

        Set<String> skillNames = input.skills() != null
                ? input.skills()
                : Collections.emptySet();

        Set<Skill> skills = skillNames.stream()
                .map(skillName -> skillRepository
                        .findBySkillName(skillName)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Skill not found: " + skillName
                                )
                        )
                )
                .collect(Collectors.toSet());

        User user = UserMapper.toDomain(input, skills);

        User savedUser = userRepository.save(user);

        return UserMapper.toOutput(savedUser);
    }
}