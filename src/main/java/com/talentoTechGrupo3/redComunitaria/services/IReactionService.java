package com.talentoTechGrupo3.redComunitaria.services;


import com.talentoTechGrupo3.redComunitaria.dto.ReactionCommentDTO;
import com.talentoTechGrupo3.redComunitaria.dto.ReactionPublicationDTO;
import com.talentoTechGrupo3.redComunitaria.entities.Reaction;

public interface IReactionService {

    Reaction createReactionPublication(ReactionPublicationDTO reactionPublicationDTO);
    Reaction createReactionComment(ReactionCommentDTO reactionCommentDTO);

}
