package com.talentoTechGrupo3.redComunitaria.dto;


import com.talentoTechGrupo3.redComunitaria.entities.ReactionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReactionCommentDTO {

    private Long userId;
    private Long commentId;
    @Enumerated(EnumType.STRING)
    private ReactionType reactionType = ReactionType.LIKE; // Valor por defecto

}
