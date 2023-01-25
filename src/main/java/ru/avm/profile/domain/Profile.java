package ru.avm.profile.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter

@Entity
@Table(name = "t_entity_profile")
public class Profile implements Serializable {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Setter
    @Column(name = "title", nullable = false)
    private String title;

    @Builder.Default
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "t_entity_profile_field",
            joinColumns = {@JoinColumn(name = "profile_name")}
    )
    @OrderColumn(name = "position", columnDefinition = "int default 0")
    private final List<ProfileField> fields = new ArrayList<>();
}
