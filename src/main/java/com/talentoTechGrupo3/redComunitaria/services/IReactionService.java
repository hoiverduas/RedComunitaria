package com.talentoTechGrupo3.redComunitaria.services;


import com.talentoTechGrupo3.redComunitaria.dto.ReactionCommentDTO;
import com.talentoTechGrupo3.redComunitaria.dto.ReactionPublicationDTO;
import com.talentoTechGrupo3.redComunitaria.entities.PublicationReaction;
import com.talentoTechGrupo3.redComunitaria.entities.Reaction;
import com.talentoTechGrupo3.redComunitaria.entities.ReactionType;

public interface IReactionService {

    Reaction createReactionPublication(Long userId, Long publicationId, ReactionType reactionType);
    Reaction createReactionComment(Long userId, Long commentId, ReactionType reactionType );
    Reaction deleteReaction(Long id);

}
