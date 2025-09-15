package ru.avm.lib.profile.domain;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.Map;

@SuppressWarnings("JpaDataSourceORMInspection")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Embeddable
public class ProfileField implements Serializable {
    @Column(name = "profile_name", insertable = false, updatable = false)
    private String profileName;
    @Column(name = "position", insertable = false, updatable = false)
    private Integer position;
    @Column(name = "name", nullable = false)
    private String dataKey;
    @Setter
    @Column(name = "type", nullable = false)
    private String type;
    @Setter
    @Column(name = "title")
    private String label;
    @Setter
    @Builder.Default
    @Column(name = "can_edit", columnDefinition = "boolean default false")
    private Boolean canEdit = false;
    @Setter
    @Column(name = "max_width")
    private Integer maxWidth;
    @Setter
    @Builder.Default
    @Column(name = "list_visible")
    private String visible = "xs";
    @Setter
    @Column(name = "sort_order")
    private Integer sortOrder;
    @Setter
    @Column(name = "sort_direction")
    private String sortDirection;
    @Setter
    @Builder.Default
    @Column(name = "show_entity", columnDefinition = "boolean default true")
    private Boolean showEntity = true;
    @Setter
    @Type(JsonType.class)
    @Column(name = "expression", columnDefinition = "json")
    private Map<String, Object> expression;
}
