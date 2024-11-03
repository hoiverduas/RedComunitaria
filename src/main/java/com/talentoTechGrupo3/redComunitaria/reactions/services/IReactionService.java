package com.talentoTechGrupo3.redComunitaria.reactions.services;

import com.talentoTechGrupo3.redComunitaria.reactions.entities.Reaction;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;

import java.util.List;

public interface IReactionService {

    Reaction createReactionPublication(Long userId, Long publicationId, ReactionType reactionType);
    Reaction createReactionComment(Long userId, Long commentId, ReactionType reactionType );
    void deleteReaction(Long id);
    List<Reaction> findByReactionByUser(Long userId);

}
