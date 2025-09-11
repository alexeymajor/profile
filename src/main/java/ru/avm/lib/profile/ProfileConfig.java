package ru.avm.lib.profile;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.avm.lib.profile.repository.ProfileRepository;

@RequiredArgsConstructor

@Configuration
public class ProfileConfig {

    private final ProfileRepository profileRepository;

    @Bean
    public ProfileMapper profileMapper() {
        return Mappers.getMapper(ProfileMapper.class);
    }

    @Bean
    public ProfileService profileService() {
        return new ProfileService(profileRepository, profileMapper());
    }

}
