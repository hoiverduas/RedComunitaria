package com.talentoTechGrupo3.redComunitaria.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ReactionType reactionType = ReactionType.REACTION_TYPE; // Valor por defecto

    @ManyToOne
    private Comment comment;

    @ManyToOne
    private Publication publication;

    @ManyToOne
    private User user;
}
