package com.talentoTechGrupo3.redComunitaria.controller;


import com.talentoTechGrupo3.redComunitaria.dto.ReactionCommentDTO;
import com.talentoTechGrupo3.redComunitaria.dto.ReactionPublicationDTO;
import com.talentoTechGrupo3.redComunitaria.entities.Reaction;
import com.talentoTechGrupo3.redComunitaria.services.impl.ReactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reactions")
public class ReactionController {

    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @PostMapping("/publication")
    public ResponseEntity<Reaction> createReactionPublication(@RequestBody ReactionPublicationDTO reactionPublicationDTO){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.reactionService.createReactionPublication(reactionPublicationDTO));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

    }

    @PostMapping("/comment")
    public ResponseEntity<Reaction> createReactionComment(@RequestBody ReactionCommentDTO reactionCommentDTO){

        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.reactionService.createReactionComment(reactionCommentDTO));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

    }
}
