package com.talentoTechGrupo3.redComunitaria.reactions.services;

import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoCommetReaction.RequestCommentReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoCommetReaction.ResponseCommentReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;

public interface ICommentReactionService {

    ResponseCommentReactionDTO createReactionComment(RequestCommentReactionDTO requestCommentReactionDTO);
}
