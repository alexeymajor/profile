package ru.avm.profile;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.transaction.annotation.Transactional;
import ru.avm.profile.dto.ProfileDto;
import ru.avm.profile.dto.ProfileFieldDto;
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

    public void updateField(String profileName, String fieldName, ProfileFieldDto profileFieldDto) {
        val field = profileRepository.findById(profileName).map(profile ->
                profile.getFields().stream().filter(profileField -> fieldName.equals(profileField.getDataKey()))
                        .findFirst().orElseThrow()).orElseThrow();
        profileMapper.updateDomain(field, profileFieldDto);
    }

    public void deleteField(String profileName, String fieldName) {
        val profile = profileRepository.findById(profileName).orElseThrow();

        profile.getFields().removeIf(profileField ->
                fieldName.equals(profileField.getDataKey()));
        profileRepository.save(profile);
    }

    @SneakyThrows
    public void addField(String profileName, ProfileFieldDto profileFieldDto) {
        val profile = profileRepository.findById(profileName).orElseThrow();

        if (profile.getFields().stream().anyMatch(profileField ->
                profileFieldDto.getDataKey().equals(profileField.getDataKey()))) {
            throw new Exception("field exists");
        }

        val field = profileMapper.toDomain(profileFieldDto, profileName);
        profile.getFields().add(field);
        profileRepository.save(profile);
    }

    public void updateProfile(String name, ProfileDto profileDto) {
        val profile = profileRepository.findById(name).orElseThrow();
        profileMapper.updateDomain(profile, profileDto);
        profileRepository.save(profile);
    }

    public void updateProfileFull(String name, ProfileDto profileDto) {
        val profile = profileRepository.findById(name).orElseThrow();
        profileMapper.updateDomainFull(profile, profileDto);
        profileRepository.save(profile);
    }
}
