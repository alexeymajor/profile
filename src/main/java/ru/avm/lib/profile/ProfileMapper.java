package ru.avm.lib.profile;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.avm.lib.profile.domain.Profile;
import ru.avm.lib.profile.domain.ProfileField;
import ru.avm.lib.profile.dto.ProfileDto;
import ru.avm.lib.profile.dto.ProfileFieldDto;

@Mapper
public interface ProfileMapper {

    ProfileDto toDto(Profile domain);

    @Mapping(target = "position", ignore = true)
    ProfileField toDomain(ProfileFieldDto dto, String profileName);

    @Mapping(target = "profileName", ignore = true)
    @Mapping(target = "position", ignore = true)
    ProfileField toDomain(ProfileFieldDto dto);

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "fields", ignore = true)
    void updateDomain(@MappingTarget Profile domain, ProfileDto profileDto);

    @Mapping(target = "name", ignore = true)
    void updateDomainFull(@MappingTarget Profile domain, ProfileDto profileDto);

    @Mapping(target = "position", ignore = true)
    @Mapping(target = "dataKey", ignore = true)
    @Mapping(target = "profileName", ignore = true)
    void updateDomain(@MappingTarget ProfileField domain, ProfileFieldDto profileDto);
}
