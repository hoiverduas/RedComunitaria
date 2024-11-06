package com.talentoTechGrupo3.redComunitaria.publications.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;
import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type_publication" // Este campo se debe incluir en el JSON
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Entrepreneurship.class, name = "ENTREPRENEURSHIP"),
        @JsonSubTypes.Type(value = Event.class, name = "EVENT")
})

@Entity
@Table(name = "publications")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_publication")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private User users;
    @OneToMany(mappedBy = "publication")
    List<Comment>comments;


}
