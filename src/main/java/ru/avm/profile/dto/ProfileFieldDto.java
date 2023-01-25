package ru.avm.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@AllArgsConstructor
@Builder
@Jacksonized
public class ProfileFieldDto {
    String dataKey;
    String label;
    String type;
    Integer maxWidth;
    @Builder.Default
    Boolean canEdit = false;
    String visible;
    @Builder.Default
    Boolean showEntity = false;
    ProfileFieldExpressionDto expression;
    Integer sortOrder;
    String sortDirection;
}
