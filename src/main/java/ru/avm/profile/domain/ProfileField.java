package ru.avm.profile.domain;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import ru.avm.profile.dto.ProfileFieldExpressionDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class),
})

@Entity
@Table(name = "t_entity_profile_field")
public class ProfileField implements Serializable {

    @Id
    @Setter
    @Column(name = "name", nullable = false)
    private String dataKey;

    @Id
    @Column(name = "profile_name", nullable = false, insertable = false, updatable = false)
    private String profileName;

    @Setter
    @Column(name = "type", nullable = false)
    private String type;

    @Setter
    @Column(name = "title")
    private String label;

    @Setter
    @Column(name = "position")
    private Integer position;

    @Setter
    @Builder.Default
    @Column(name = "can_edit", nullable = false, columnDefinition = "boolean default false")
    private Boolean canEdit = false;

    @Setter
    @Column(name = "max_width")
    private Integer maxWidth;

    @Setter
    @Builder.Default
    @Column(name = "list_visible")
    private String visible = "xs";

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "sort_direction")
    private String sortDirection;

    @Setter
    @Builder.Default
    @Column(name = "show_entity", nullable = false, columnDefinition = "boolean default true")
    private Boolean showEntity = true;

    @Type(type = "json")
    @Column(name = "expression", columnDefinition = "json")
    private ProfileFieldExpressionDto expression;
}
