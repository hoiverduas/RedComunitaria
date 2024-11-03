package com.talentoTechGrupo3.redComunitaria.entities.reactioEntities;


import com.talentoTechGrupo3.redComunitaria.entities.userEntities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "reaction_category")

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;

    @ManyToOne(optional = false)
    private User user;

}
