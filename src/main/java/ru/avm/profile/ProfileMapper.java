package ru.avm.profile;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.avm.profile.domain.Profile;
import ru.avm.profile.domain.ProfileField;
import ru.avm.profile.dto.ProfileDto;
import ru.avm.profile.dto.ProfileFieldDto;

@Mapper
public interface ProfileMapper {

    ProfileDto toDto(Profile domain);

    @Mapping(target = "profileName", ignore = true)
    ProfileField toDomain(ProfileFieldDto dto);

    @Mapping(target = "name", source = "name")
    Profile toDomain(ProfileDto dto, String name);

    @Mapping(target = "name", ignore = true)
    void updateDomain(@MappingTarget Profile domain, ProfileDto profileDto);
}
