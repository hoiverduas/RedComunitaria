package com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoPublicatioReaction;

import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePublicationReactionDTO {

    private Long id;
    private Long userId;
    private Long publicationId;
    private ReactionType reactionType;

}
