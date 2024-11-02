package com.talentoTechGrupo3.redComunitaria.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;


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


    @OneToMany(mappedBy = "users")
    List<Comment> comments;


    @OneToMany(mappedBy = "users")
    List<Publication> publications;

    @ManyToOne
    private City cities;

    @OneToMany(mappedBy = "user")
    private List<Reaction> reactions;

    @Transient
    @JsonProperty("role")
    public String getRole() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }

}

