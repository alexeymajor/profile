package ru.avm.profile;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.transaction.annotation.Transactional;
import ru.avm.profile.dto.ProfileDto;
import ru.avm.profile.repository.ProfileRepository;

import java.util.Optional;

@RequiredArgsConstructor

@Transactional
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public Optional<ProfileDto> getProfile(String name) {
        return profileRepository.findById(name).map(profileMapper::toDto);
    }

    public void updateProfile(String name, ProfileDto profileDto) {
        val profile = profileRepository.findById(name).map(prof -> {
            profileMapper.updateDomain(prof, profileDto);
            return prof;
        }).orElse(profileMapper.toDomain(profileDto, name));
        profileRepository.save(profile);
    }
}
