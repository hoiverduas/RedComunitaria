package com.talentoTechGrupo3.redComunitaria.reactions.controller;


import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoPublicatioReaction.RequestPublicationReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoPublicatioReaction.ResponsePublicationReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.PublicationReaction;
import com.talentoTechGrupo3.redComunitaria.reactions.services.impl.PublicationReactionService;
import com.talentoTechGrupo3.redComunitaria.reactions.services.impl.ReactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publicationReaction")
public class PublicationReactionController {

    private final PublicationReactionService publicationReactionService;

    public PublicationReactionController(PublicationReactionService publicationReactionService) {
        this.publicationReactionService = publicationReactionService;
    }

    @PostMapping
    public ResponseEntity<ResponsePublicationReactionDTO> createPublicationReaction(RequestPublicationReactionDTO requestPublicationReactionDTO){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.publicationReactionService.createReactionPublication(requestPublicationReactionDTO));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }

}
