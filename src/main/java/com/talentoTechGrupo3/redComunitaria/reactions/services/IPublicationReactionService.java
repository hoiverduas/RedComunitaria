package com.talentoTechGrupo3.redComunitaria.reactions.services;

import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoPublicatioReaction.RequestPublicationReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoPublicatioReaction.ResponsePublicationReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.PublicationReaction;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.Reaction;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;

public interface IPublicationReactionService {

    ResponsePublicationReactionDTO createReactionPublication(RequestPublicationReactionDTO requestPublicationReactionDTO);
    String deleteReactionById(Long id);


}
