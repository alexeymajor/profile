package ru.avm.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class ProfileFieldDto {
    String dataKey;
    String label;
    String type;
    Integer maxWidth;
    Integer position;
    Boolean canEdit;
    String visible;
    Boolean showEntity;
    ProfileFieldExpressionDto expression;
    Integer sortOrder;
    String sortDirection;
}
