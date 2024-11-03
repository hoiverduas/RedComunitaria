package com.talentoTechGrupo3.redComunitaria.entities.commentEntities;


import com.talentoTechGrupo3.redComunitaria.entities.commentEntities.Comment;
import com.talentoTechGrupo3.redComunitaria.entities.reactioEntities.Reaction;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("COMMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentReaction extends Reaction {

    @ManyToOne(optional = false)
    private Comment comment; // Relación con el comentario


}
