package ru.avm.profile;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.transaction.annotation.Transactional;
import ru.avm.profile.domain.Profile;
import ru.avm.profile.dto.ProfileDto;
import ru.avm.profile.repository.ProfileRepository;

@RequiredArgsConstructor

@Transactional
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public ProfileDto getProfile(String name) {
        return profileRepository.findById(name)
                .map(profileMapper::toDto).orElseGet(() -> ProfileDto.builder().name(name).build());
    }

    public void updateProfile(String name, ProfileDto profileDto) {
        val profile = profileRepository.findById(name).orElseGet(() -> Profile.builder().name(name).build());
        profileMapper.updateDomainFull(profile, profileDto);
        profileRepository.save(profile);
    }
}
