package ru.avm.profile.domain;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import ru.avm.profile.dto.ProfileFieldExpressionDto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class),
})

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
    @Type(type = "json")
    @Column(name = "expression", columnDefinition = "json")
    private ProfileFieldExpressionDto expression;
}
