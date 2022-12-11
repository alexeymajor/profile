package ru.avm.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class ProfileFieldExpressionDto {
    String type;
    String path;
    String idKey;
    String nameKey;
    String formikId;
    boolean multiple;
    boolean permissions;
}
