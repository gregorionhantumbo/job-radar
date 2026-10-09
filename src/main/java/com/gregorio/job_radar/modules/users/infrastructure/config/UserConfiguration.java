package com.gregorio.job_radar.modules.users.infrastructure.config;

import com.gregorio.job_radar.modules.users.application.mapper.UserMapper;
import com.gregorio.job_radar.modules.users.application.repository.SkillRepository;
import com.gregorio.job_radar.modules.users.application.repository.UserRepository;
import com.gregorio.job_radar.modules.users.application.usecase.skill.*;
import com.gregorio.job_radar.modules.users.application.usecase.user.*;
import com.gregorio.job_radar.modules.users.application.usecaseimpl.skill.*;
import com.gregorio.job_radar.modules.users.application.usecaseimpl.user.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public CreateUserUseCase createUserUseCase(
            UserRepository userRepository,
            SkillRepository skillRepository
    ) {
        return new CreateUserUseCaseImpl(
                userRepository,
                skillRepository
        );
    }


    @Bean
    public UpdateUserUseCase updateUserUseCase(
            UserRepository userRepository,
            SkillRepository skillRepository
    ) {
        return new UpdateUserUseCaseImpl(
                userRepository,
                skillRepository
        );
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase(
            UserRepository userRepository
    ) {
        return new DeleteUserUseCaseImpl(userRepository);
    }

    @Bean
    public SetFavoriteUseCase setFavoriteUseCase(
            UserRepository userRepository
    ) {
        return new SetFavoriteUseCaseImpl(userRepository);
    }

    @Bean
    public GetUsersUseCase getUsersUseCase(
            UserRepository userRepository
    ) {
        return new GetUsersUseCaseImpl(userRepository);
    }

    @Bean
    public GetDeletedUsersUseCase getDeletedUsersUseCase(
            UserRepository userRepository
    ) {
        return new GetDeletedUsersUseCaseImpl(userRepository);
    }

    @Bean
    public CreateSkillUseCase createSkillUseCase(
            SkillRepository skillRepository
    ) {
        return new CreateSkillUseCaseImpl(skillRepository);
    }

    @Bean
    public UpdateSkillUseCase updateSkillUseCase(
            SkillRepository skillRepository
    ) {
        return new UpdateSkillUseCaseImpl(skillRepository);
    }

    @Bean
    public DeleteSkillUseCase deleteSkillUseCase(
            SkillRepository skillRepository
    ) {
        return new DeleteSkillUseCaseImpl(skillRepository);
    }

    @Bean
    public GetSkillsUseCase getSkillsUseCase(
            SkillRepository skillRepository
    ) {
        return new GetSkillsUseCaseImpl(skillRepository);
    }

    @Bean
    public GetDeletedSkillsUseCase getDeletedSkillsUseCase(
            SkillRepository skillRepository
    ) {
        return new GetDeletedSkillsUseCaseImpl(skillRepository);
    }
}