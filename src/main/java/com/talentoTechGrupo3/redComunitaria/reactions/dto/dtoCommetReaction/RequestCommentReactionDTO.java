package com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoCommetReaction;

import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCommentReactionDTO {

    private Long userId;
    private Long commentId;
    private ReactionType reactionType;
}
