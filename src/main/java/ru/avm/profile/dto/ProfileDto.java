package ru.avm.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
@Builder
public class ProfileDto {
    String name;
    String title;
    String width;
    List<ProfileFieldDto> fields;
}
