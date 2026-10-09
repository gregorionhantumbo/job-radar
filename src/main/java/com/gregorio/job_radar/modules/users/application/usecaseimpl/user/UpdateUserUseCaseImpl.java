
package com.gregorio.job_radar.modules.users.application.usecaseimpl.user;

import com.gregorio.job_radar.modules.users.application.dto.UpdateUserInput;
import com.gregorio.job_radar.modules.users.application.dto.UserOutput;
import com.gregorio.job_radar.modules.users.application.mapper.UserMapper;
import com.gregorio.job_radar.modules.users.application.repository.SkillRepository;
import com.gregorio.job_radar.modules.users.application.repository.UserRepository;
import com.gregorio.job_radar.modules.users.application.usecase.user.UpdateUserUseCase;
import com.gregorio.job_radar.modules.users.domain.Skill;
import com.gregorio.job_radar.modules.users.domain.User;
import com.gregorio.job_radar.shared.exception.DuplicateResourceException;
import com.gregorio.job_radar.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserRepository userRepository;
    private final SkillRepository skillRepository;

    public UpdateUserUseCaseImpl(
            UserRepository userRepository,
            SkillRepository skillRepository
    ) {
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public UserOutput execute(UpdateUserInput input) {
        UUID uuid = input.uuid();

        User user = userRepository.findByUuid(uuid)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found: " + uuid
                        )
                );

        if (!user.getUsername().equalsIgnoreCase(input.username())
                && userRepository.existsByUsername(input.username())) {
            throw new DuplicateResourceException(
                    "Username already exists: " + input.username()
            );
        }

        if (!user.getEmail().equalsIgnoreCase(input.email())
                && userRepository.existsByEmail(input.email())) {
            throw new DuplicateResourceException(
                    "Email already exists: " + input.email()
            );
        }

        Set<String> requestedSkillNames = input.skills() == null
                ? Set.of()
                : input.skills();

        Set<Skill> skills = requestedSkillNames.stream()
                .map(name -> skillRepository.findBySkillName(name)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Skill not found: " + name
                                )
                        ))
                .collect(Collectors.toCollection(HashSet::new));

        user.setFullName(input.fullName());
        user.setUsername(input.username());
        user.setContact(input.contact());
        user.setTitle(input.title());
        user.setEmail(input.email());
        user.setSkills(skills);

        User updatedUser = userRepository.save(user);

        return UserMapper.toOutput(updatedUser);
    }
}