package com.talentoTechGrupo3.redComunitaria.users.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Publication;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.Reaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "roles"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Entrepreneur.class, name = "ENTREPRENEUR"),
        @JsonSubTypes.Type(value = Admin.class, name = "ADMIN")
})



@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean locked;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean disabled;


    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Comment> comments;


    @OneToMany(mappedBy = "users" ,fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Publication> publications;

    @ManyToOne
    @JsonManagedReference
    private City cities;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Reaction> reactions;

    @Transient
    @JsonProperty("role")
    public String getRole() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }

}

