package com.talentoTechGrupo3.redComunitaria.reactions.dto;

import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReactionPublicationDTO {

    private Long userId;
    private Long publicationId;
    @Enumerated(EnumType.STRING)
    private ReactionType reactionType = ReactionType.LIKE; // Valor por defecto


}
